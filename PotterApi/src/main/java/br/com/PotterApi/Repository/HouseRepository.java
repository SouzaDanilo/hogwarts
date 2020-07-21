package br.com.PotterApi.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.PotterApi.Model.House;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer>{

}
