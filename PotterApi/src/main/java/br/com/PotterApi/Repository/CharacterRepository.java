package br.com.PotterApi.Repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.PotterApi.Model.Character;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
	
	 List<Character> findAll(Specification<Character> completeQuery);

}
