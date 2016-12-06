package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import main.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{}
