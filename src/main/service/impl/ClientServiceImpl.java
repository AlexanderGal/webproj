package main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.entity.Client;
import main.repository.ClientRepository;
import main.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
	@Autowired
	ClientRepository clientRepository;

	@Override
	public Client addClient(Client client) {
		return clientRepository.saveAndFlush(client);
	}

	@Override
	public void delete(long id) {
		clientRepository.delete(id);
	}

	@Override
	public Client getByName(String name) {
		return clientRepository.findByName(name);
	}

	@Override
	public Client getById(long id) {
		return clientRepository.findById(id);
	}

	@Override
	public Client updateClient(Client client) {
		return clientRepository.saveAndFlush(client);
	}

	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	}
}
