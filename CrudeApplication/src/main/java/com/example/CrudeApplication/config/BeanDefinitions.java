package com.example.CrudeApplication.config;

import com.example.CrudeApplication.entity.MyBean;
import com.example.CrudeApplication.entity.MySecondBean;
import com.example.CrudeApplication.entity.MySecondBean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example")
public class BeanDefinitions {


    @Bean
    public MySecondBean myBean1()
    {
        return new MySecondBean("dasu sekhar");
    }

    @Bean
    public MyBean myBean()
    {
        return new MyBean(56);

    }


    @Bean
    public MySecondBean2 getMybean2()
    {

        return new MySecondBean2("dasu");
    }


}
