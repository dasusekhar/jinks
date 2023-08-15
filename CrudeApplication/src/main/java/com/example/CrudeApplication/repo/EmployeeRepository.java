package com.example.CrudeApplication.repo;

import com.example.CrudeApplication.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


@org.springframework.stereotype.Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

Page<Employee> findAll(Pageable pageable);

}
