package main.service;

import java.util.List;
import main.entity.Client;

public interface ClientService {
	Client addClient(Client client);
	void delete(long id);
	Client getByName(String name);
	Client getById(long id);
	Client updateClient(Client client);
	List<Client> findAll();
}
