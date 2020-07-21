package br.com.PotterApi.Service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.PotterApi.Model.House;
import br.com.PotterApi.Repository.HouseRepository;

@Service
public class HouseService {
	
	@Autowired
    private HouseRepository houseRepository;
	
	/**
	 * listing house from repository using id as parameter
	 * @param idHouse
	 */
	public House findById(Integer idHouse) {

        Optional<House> obj = houseRepository.findById(idHouse);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " +idHouse, "Type: " + House.class.getName()));

    }
	
	
	/**
	 * listing all houses from repository
     * @return
     */
    public List<House> findAll() {
        return houseRepository.findAll();
    }

}
