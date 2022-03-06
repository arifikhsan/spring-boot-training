package com.example.demo.controller;

import com.example.demo.dto.StaffDto;
import com.example.demo.entity.StaffEntity;
import com.example.demo.service.StaffService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/staff")
public class StaffController {
    StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping("")
    public StaffEntity addProduct(@RequestBody StaffDto request) {
        return staffService.add(request);
    }
}
