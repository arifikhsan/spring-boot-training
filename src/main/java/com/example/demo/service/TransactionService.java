package com.example.demo.service;

import com.example.demo.entity.TransactionEntity;
import com.example.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<TransactionEntity> all() {
        return repository.findAll();
    }

    public TransactionEntity create(TransactionEntity transaction) {
        return repository.save(transaction);
    }
}
