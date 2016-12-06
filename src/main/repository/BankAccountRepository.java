package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import main.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long>{}
