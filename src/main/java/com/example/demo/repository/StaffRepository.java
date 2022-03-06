package com.example.demo.repository;

import com.example.demo.entity.StaffEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends CrudRepository<StaffEntity, Long> {
}
