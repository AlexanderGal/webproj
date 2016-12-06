package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.entity.Worker;
import main.repository.WorkerRepository;

@Service
public class WorkerServiceImpl implements WorkerService{
	@Autowired
	WorkerRepository workerRepository;
	
	@Override
	public Worker addWorker(Worker worker) {
		return workerRepository.saveAndFlush(worker);
	}

	@Override
	public Worker findByName(String name) {
		return workerRepository.findByName(name);
	}

	@Override
	public Worker findById(long id) {
		return workerRepository.findById(id);
	}

	@Override
	public void deleteWorker(long id) {
		workerRepository.delete(id);
	}

	@Override
	public Worker updateWorker(Worker worker) {
		return workerRepository.saveAndFlush(worker);
	}

	@Override
	public List<Worker> findAll() {
		return workerRepository.findAll();
	}
}
