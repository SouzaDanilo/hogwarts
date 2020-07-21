package br.com.PotterApi.Controller;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.PotterApi.Exception.ErroException;
import br.com.PotterApi.Model.Character;
import br.com.PotterApi.Model.House;
import br.com.PotterApi.Service.CharacterService;
import br.com.PotterApi.Service.HouseService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class PotterApiController {
	
	@Autowired
    private CharacterService characterService;
	
	@Autowired
    private HouseService houseService;

	@ApiOperation(value = "creating new character and save in the repository")
    @PostMapping("characters")
    public ResponseEntity<Character> signUpCharacter(@RequestBody @Valid Character body) {

        if(body.getId() != null) {
            throw new ErroException("Inconsistent request");

        }
        final Character response = characterService.save(body);
        final URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        		.path("/{id}").buildAndExpand(body.getId()).toUri();
        final HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(location);
        return new ResponseEntity<>(response,responseHeaders, HttpStatus.OK);
    }

    
   @ApiOperation(value = "Retorna uma lista de pessoas")
   @PutMapping("characters/{id}")
    public ResponseEntity<Character> updateCharacter(@RequestBody Character body, @PathVariable Integer id) {

        if(body.getId() == null || !id.equals(body.getId())) {
            throw new ErroException("Inconsistent request");
        }
        body.setId(id);
        final Character response = characterService.save(body);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

   
   
    @ApiOperation(value = "Retorna uma lista de pessoas")
    @DeleteMapping("characters/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Integer id) {

    	characterService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    
    
    @ApiOperation(value = "Retorna uma lista de pessoas")
    @GetMapping("characters/{id}")
    public ResponseEntity<Character> findCharacter(@PathVariable Integer id) {
    	
        final Character response = characterService.findById(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


    @ApiOperation(value = "return list of characters")
    @GetMapping("characters")
    public ResponseEntity<List<Character>> listCharacters(@RequestParam (value = "house", required = false) String house) {

        List<Character> listResponse = null;

        if(StringUtils.hasText(house)) {
            listResponse = characterService.findByFilter(house);
        } else {
        	listResponse = characterService.findAll();
        }
        return new ResponseEntity<>(listResponse, HttpStatus.OK);
    }
    
    
    @ApiOperation(value = "return house using id as parameter")
    @GetMapping("houses/{idHouse}")
    public ResponseEntity<House> findHouse(@PathVariable Integer idHouse) {
    	
        final House response = houseService.findById(idHouse);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    
    
    @ApiOperation(value = "return list of houses")
    @GetMapping("houses")
    public ResponseEntity<List<House>> listHouses() {

    	List<House> listResponse = null;
    	listResponse = houseService.findAll();
        return new ResponseEntity<>(listResponse, HttpStatus.OK);
    }

}
