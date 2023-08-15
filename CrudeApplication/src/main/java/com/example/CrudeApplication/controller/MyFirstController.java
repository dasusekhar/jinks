package com.example.CrudeApplication.controller;

import com.example.CrudeApplication.config.BeanDefinitions;
import com.example.CrudeApplication.entity.MyBean;
import com.example.CrudeApplication.entity.MySecondBean;
import com.example.CrudeApplication.entity.MySecondBean2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api")
public class MyFirstController {

//   @Autowired
//   @Qualifier("myBean")
//   private BeanDefinitions mybean;


//    @Autowired
//    @Qualifier("MySecondBean")
//    private BeanDefinitions mysecondBean;
//
//    @Autowired
//    @Qualifier("MySecondBean2")
//    private BeanDefinitions mysecondbean2;

    @Autowired
    private MyBean mybean;

    @Autowired
    private MySecondBean mySecondBean;

    @Autowired
    private MySecondBean2 mySecondBean2;




    @GetMapping("/get")
    public String welcome(){
        return
                "welcome to spring and springboot "+mybean.getX();
    }


    @GetMapping("/get/second")
    public String welcome2(){
        return
                "welcome to spring and springboot "+mySecondBean.getMyName();
    }

    @GetMapping("/get/thrid")
    public String welcome3(){
        return
                "welcome to spring and springboot "+mySecondBean2.getMyName();
    }
}
