package com.example.CrudeApplication.controller;

import com.example.CrudeApplication.entity.Employee;
import com.example.CrudeApplication.exception.ErrorResponse;
import com.example.CrudeApplication.exception.MyCustomException;
import com.example.CrudeApplication.service.EmployeeService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/vi/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    Logger logger= LoggerFactory.getLogger(EmployeeController.class);


    @PostMapping("/save")
    public ResponseEntity<Employee>create(@RequestBody Employee employee)
    {
        logger.debug("request {}",employee.toString());
        Employee savedEmployee=employeeService.save(employee);
        logger.debug("response is : ",savedEmployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Employee>getById(@PathVariable("id")Integer id)
    {
        Employee employee=employeeService.findById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @GetMapping("/listOf")
    public ResponseEntity<List<Employee>>listOfEmployee(@RequestParam List<Integer>ids)
    {
        List<Employee>listOfEmployee=employeeService.listOf(ids);
        return new ResponseEntity<>(listOfEmployee,HttpStatus.OK);
    }



    @PutMapping("/{id}")
  //  @PatchMapping("/{id}")
    public ResponseEntity<Employee>update(@RequestBody Employee employee, @PathVariable("id") Integer id)
    {
        Employee updated=employeeService.update(employee,id);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }


    // pagination and sorting



    @GetMapping("/pagination/{pageNumber}/{pageSize}")
    public ResponseEntity<Page<Employee>>getPagination(@PathVariable Integer pageNumber,@PathVariable Integer pageSize)
    {
        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        Page<Employee>page=employeeService.findAll(pageable);
        return new ResponseEntity<>(page,HttpStatus.OK);
    }


    @ExceptionHandler(value = MyCustomException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleCustomerAlreadyExistsException(
            MyCustomException ex)
    {
        return new ErrorResponse(608,
                ex.getMessage());
    }

}
