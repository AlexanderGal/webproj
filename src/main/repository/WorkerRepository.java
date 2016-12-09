package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import main.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{
	@Query("select w from Worker w where w.firstName = :name")
	Worker findByName(@Param("name") String name);
	
	@Query("select w from Worker w where w.id = :id")
	Worker findById(@Param("id") long id);
}
