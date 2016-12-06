package main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import main.entity.Bank;
import main.repository.BankRepository;
import main.service.BankService;

public class BankServiceImpl implements BankService{
	@Autowired
	BankRepository bankRepository;
	
	@Override
	public Bank addBank(Bank bank) {
		return bankRepository.saveAndFlush(bank);
	}

	@Override
	public void delete(long id) {
		bankRepository.delete(id);
	}

	@Override
	public Bank getByName(String name) {
		return bankRepository.findByName(name);
	}

	@Override
	public Bank editBank(Bank bank) {
		return bankRepository.saveAndFlush(bank);
	}

	@Override
	public List<Bank> getAll() {
		return bankRepository.findAll();
	}
}
