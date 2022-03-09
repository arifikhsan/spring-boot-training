package com.example.demo.controller;

import com.example.demo.dto.StaffDto;
import com.example.demo.entity.StaffEntity;
import com.example.demo.service.StaffService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/staff")
public class StaffController {
    StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping
    public StaffEntity create(@RequestBody StaffDto request) {
        return staffService.create(request);
    }

    @PutMapping("{id}/update-balance")
    public StaffEntity updateBalance(
            @PathVariable long id,
            @RequestParam int balance
    ) throws Exception {
        return staffService.updateBalance(id, balance);
    }

    @GetMapping("{id}")
    public StaffEntity one(@PathVariable long id) throws Exception {
        return staffService.one(id);
    }
}
