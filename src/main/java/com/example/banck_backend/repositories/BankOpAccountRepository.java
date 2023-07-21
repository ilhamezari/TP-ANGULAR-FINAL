package com.example.banck_backend.repositories;

import com.example.banck_backend.entities.AOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;

public interface BankOpAccountRepository extends JpaRepository<AOperation,Long> {
List<AOperation> findByBankAccountId(String accountId);
   Page<AOperation> findByBankAccountId(String accountId, Pageable pageable);


}

