package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import main.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	@Query("select b from Client b where b.id = :id")
	Client findById(@Param("id")long id);
	
	@Query("select c from Client c where c.firstName = :name")
	Client findByName(@Param("name") String name);
}
