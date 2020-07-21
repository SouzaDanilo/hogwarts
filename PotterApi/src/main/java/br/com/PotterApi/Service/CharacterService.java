package br.com.PotterApi.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.PotterApi.Exception.ErroException;
import br.com.PotterApi.Model.Character;
import br.com.PotterApi.Repository.CharacterRepository;

@Service
public class CharacterService {
	
	public static final List<String> VALID_HOUSE = Arrays.asList( new String [] {"Gryffindor","Ravenclaw","Slytherin","Hufflepuff"});
	
	public static final List<String> BlOOD_STATUS = Arrays.asList( new String [] {"pure-blood","half-blood","muggle-born","unknown"});
	
	@Autowired
    private CharacterRepository characterRepository;
	
   /**
    * searching in the repository using id
    */
    public Character findById(Integer id) {

        Optional<Character> obj = characterRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " +id, "Type: " + Character.class.getName()));

    }

    
    /**
     * validation of data to save in the repository
     * @param body
     */
    public Character save(Character body) {

        if(body.getId() != null && characterRepository.findById(body.getId()) == null ) {
            throw new ErroException("Attempt to update a non-existing record");

        } else if(!houseValidation(body.getHouse(), VALID_HOUSE)) {
        	 throw new ErroException("The house name is not valid");
        	
        } else if (!bloodStatusValidation(body.getBloodStatus(),BlOOD_STATUS)) {
        	throw new ErroException("The blood status is not valid");
        	
        }
        
        return characterRepository.save(body);
    }


    
    /**
     * deleting from repository data using id as parameter
     * @param id
     */
    public void delete(Integer id) {

        try {
        	characterRepository.deleteById(id);
        }
        catch (final EmptyResultDataAccessException e) {
            throw new ErroException("Attempted to remove a non-existing record");
        }
    }
    

    /**
     * listing all data from repository
     */
    public List<Character> findAll() {
        return characterRepository.findAll();
    }

    

    /**
     * using house as parameter to listing
     * @param house
     * @return
     */
    public List<Character> findByFilter(String house){

        final List <Specification<Character>> specifications = new ArrayList<>();

        if(StringUtils.hasText(house)) {
            specifications.add((root, query, cb) -> cb.equal(cb.upper(root.get("house")), house));
        }

        Specification<Character> completeQuery = null;

        for(final Specification<Character> specification : specifications) {
            if(completeQuery == null) {
                completeQuery = specification;
            } else {
                completeQuery = Specification.where(completeQuery).and(specification);
            }
        }
        return characterRepository.findAll(completeQuery);

    }

    

    private boolean houseValidation(String houses,List<String> allowedHouses) {
    	return allowedHouses.contains(houses);
    	
    }
    
    private boolean bloodStatusValidation(String bloodStatus,List<String> allowedStatus) {
    	return allowedStatus.contains(bloodStatus);
    	
    }
    
}
