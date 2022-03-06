package com.example.demo.service;

import com.example.demo.dto.StaffDto;
import com.example.demo.entity.BasketEntity;
import com.example.demo.entity.StaffEntity;
import com.example.demo.repository.StaffRepository;
import org.springframework.stereotype.Service;

@Service
public class StaffService {
    StaffRepository repository;

    public StaffService(StaffRepository repository) {
        this.repository = repository;
    }

    public StaffEntity add(StaffDto request) {
        StaffEntity staff = new StaffEntity();
        staff.setName(request.getName());
        staff.setBasket(new BasketEntity());

        return repository.save(staff);
    }

}
