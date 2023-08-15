package com.example.CrudeApplication.service.impl;

import com.example.CrudeApplication.entity.Employee;
import com.example.CrudeApplication.exception.MyCustomException;
import com.example.CrudeApplication.exception.MySalaryBusinessException;
import com.example.CrudeApplication.repo.EmployeeRepository;
import com.example.CrudeApplication.service.EmployeeService;
import com.example.CrudeApplication.util.NotificationMail;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee save(Employee employee) {
        if(employee.getSalary()<50000)
        {
            throw new MySalaryBusinessException(605,"salary should not less than '50000'   : "+employee.getSalary());
        }
     return employeeRepository.save(employee);
    }


    public static Integer myNumber()
    {
      String number=  NotificationMail.sendMail("id");
      return Integer.valueOf(number);
    }
    @Override
    public  Employee findById(Integer id) throws MyCustomException {
       return   employeeRepository.findById(myNumber()).orElseThrow(()->{
          return   new MyCustomException("emploee id not avaliable  :  "+ NotificationMail.sendMail("id"));

       });

    }

    @Override
    public List<Employee> listOf(List<Integer> ids) {

        return employeeRepository.findAllById(ids);
    }

    @Override
    public Employee update(Employee employee, Integer id) {

        Employee employee1=employeeRepository.findById(id).orElseThrow(()->{
            throw new MyCustomException("emplyee id not avalliable for update the record : "+id);
        });
        employee1.setMobileNumber(employee.getMobileNumber());
        employee1.setName(employee.getName());
        employee1.setLocation(employee.getLocation());

        return employeeRepository.save(employee1);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {

        Page<Employee>pageables=employeeRepository.findAll(pageable);
        return pageables;
    }



//    @Override
//    public Page<Employee> findAll(Pageable pageable) {
//        Page<Employee>get=employeeRepository.findAll(pageable);
//        return get.map(x->{
//            return new Employee();
//        });
//    }
}
