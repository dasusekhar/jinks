package com.example.CrudeApplication.service.impl;

import com.example.CrudeApplication.entity.Employee;
import com.example.CrudeApplication.repo.EmployeeRepository;
import com.example.CrudeApplication.service.EmployeeService;
import com.example.CrudeApplication.util.NotificationMail;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@SpringBootTest
@RunWith(PowerMockRunner.class)
class EmployeeServiceImplTest {
///@InjectMocks
    @Autowired
    private EmployeeService employeeService;

  //  @Autowired
    @MockBean
    private EmployeeRepository employeeRepository;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(NotificationMail.class);
    }


    @BeforeEach
    public void beforeEach()
    {
        Employee employee=new Employee();
        employee.setId(1);
        employee.setLocation("kukatpally");
        employee.setName("dasu sekhar");
        employee.setMobileNumber("8466811174");
      //  employeeRepository.save(employee);
        Mockito.when(employeeRepository.findById(1))
                .thenReturn(Optional.of(employee));
    }

    @Test
    void save() {





    }

    @Test
    void findById() {

        Employee employee=employeeService.findById(1);
        assertThat(employee.getName())
                .isEqualTo("dasu sekhar");
        assertEquals(employee.getMobileNumber(),"8466811174");



    }

    @Test
    void listOf() {







    }

    @Test
    void myNumber() {

        mockStatic(NotificationMail.class);
        when(NotificationMail.sendMail("id")).thenReturn("1");


    }
}