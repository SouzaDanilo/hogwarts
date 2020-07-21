package br.com.PotterApi.Controller;



import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.PotterApi.Model.Character;
import br.com.PotterApi.Model.House;
import br.com.PotterApi.Service.CharacterService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PotterApiControllerTest {
	
	@Autowired
	private PotterApiController PotterApiController;
	
	@Autowired
	private CharacterService characterService;
	
	 @Test
	 public void addCharacterTest(){
		 
		 Character character = new Character();
		 character.setName("Rosa");
		 character.setHouse("Hufflepuff");
		 character.setSpecies("human");
		 character.setBloodStatus("pure-blood");
		 character.setRole("student");
		 character.setSchool("Hogwarts School of Witchcraft and Wizardry");
		 character.setDeathEater(true);
		 character.setDumbledoresArmy(false);
		 character.setOrderOfThePhoenix(true);
		 character.setMinistryOfMagic(false);
		 PotterApiController.signUpCharacter(character);
	 }
	 
	 @Test
	 public void updateCharacterTest() {
		 
		 Character character = new Character();
		 character.setId(9);
		 character.setName("Rosa");
		 character.setHouse("Hufflepuff");
		 character.setSpecies("human");
		 character.setBloodStatus("pure-blood");
		 character.setRole("Student");
		 character.setSchool("Hogwarts School of Witchcraft and Wizardry");
		 character.setDeathEater(true);
		 character.setDumbledoresArmy(false);
		 character.setOrderOfThePhoenix(true);
		 character.setMinistryOfMagic(false);
		 PotterApiController.updateCharacter(character, 9);
	 }
	 
	 @Test
	 public void findCharacterTest() {
		 
		 Character character = new Character();
		 character.setId(9);
		 PotterApiController.findCharacter(character.getId());
		 
	 }
	 
	 @Test
	 public void findAllCharacterTest() {
		 characterService.findAll();
	 }
	 
	 @Test
	 public void findAllCharacterByHouseTest() {
		 
		 Character character = new Character();
		 character.setHouse("Hufflepuff");
		 characterService.findByFilter(character.getHouse());
	 }
	 
	 
	 @Test
	 public void deleteCharacterTest() {
		 
		 Character character = new Character();
		 character.setId(1);
		 PotterApiController.deleteCharacter(character.getId());
	 }
	 
	 @Test
	 public void findHouseTest() {

		 House house = new House();
		 house.setIdHouse(1);
		 PotterApiController.findHouse(house.getIdHouse());

	 }
	 
	 @Test
	 public void listHousesTest() {
		 PotterApiController.listHouses();
	 }

}
