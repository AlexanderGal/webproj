package main.service;

import java.util.List;
import main.entity.Bank;

public interface BankService {
	Bank addBank(Bank bank);
	void delete(long id);
	Bank getByName(String name);
	Bank editBank(Bank bank);
	List<Bank> getAll();
}
