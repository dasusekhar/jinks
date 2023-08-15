package com.example.CrudeApplication.service;

import com.example.CrudeApplication.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);

    Employee findById(Integer id);

    List<Employee> listOf(List<Integer> ids);

    Employee update(Employee employee, Integer id);

    Page<Employee> findAll(Pageable pageable);

    //  Page<Employee> findAll(Pageable pageable);
}
