package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import main.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	@Query("select from Client c where c.id = :id")
	Client findById(@Param("id")long id);
	
	@Query("select from Client c where c.name = :name")
	Client findByName(@Param("name") String name);
}
