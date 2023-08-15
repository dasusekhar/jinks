package com.example.CrudeApplication.service.impl;

import com.example.CrudeApplication.entity.People;
import com.example.CrudeApplication.repo.PeopleRepository;
import com.example.CrudeApplication.service.PeropleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleServiceImpl implements PeropleService {

    @Autowired
    private PeopleRepository peopleRepository;


    @Override
    public People create(People people) {
        return peopleRepository.save(people);
    }

    @Override
    public People updateStatus() {



        return null;
    }
}
