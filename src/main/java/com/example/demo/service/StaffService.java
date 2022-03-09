package com.example.demo.service;

import com.example.demo.dto.StaffDto;
import com.example.demo.entity.BasketEntity;
import com.example.demo.entity.StaffEntity;
import com.example.demo.repository.StaffRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StaffService {
    StaffRepository repository;

    public StaffService(StaffRepository repository) {
        this.repository = repository;
    }

    public StaffEntity create(StaffDto staffDto) {
        StaffEntity staff = new StaffEntity(staffDto.getName(), new BasketEntity());
        return repository.save(staff);
    }

    @Transactional
    public StaffEntity updateBalance(long id, int balance) throws Exception {
        var staff = one(id);
        staff.setBalance(staff.getBalance() + balance);
        return staff;
    }

    public StaffEntity one(long id) throws Exception {
        var staffOption = repository.findById(id);
        if (staffOption.isEmpty()) throw new Exception("Staff tidak ditemukan");
        return staffOption.get();
    }
}
