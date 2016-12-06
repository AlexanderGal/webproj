package main.service;

import java.util.List;

import main.entity.Worker;

public interface WorkerService {
	Worker addWorker(Worker worker);
	Worker findByName(String name);
	Worker findById(long id);
	void deleteWorker(long id);
	Worker updateWorker(Worker worker);
	List<Worker> findAll();
}
