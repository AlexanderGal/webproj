package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import main.entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Long>{
	@Query("select b from Bank b where b.name = :name")
	Bank findByName(@Param("name") String name);
}
