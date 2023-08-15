package com.example.CrudeApplication.controller;

import com.example.CrudeApplication.entity.People;
import com.example.CrudeApplication.service.PeropleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PeopleController {
    @Autowired
    private PeropleService peropleService;


    @PostMapping("/save")
    public ResponseEntity<People>create(@RequestBody People people)
    {
        People saved=peropleService.create(people);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }




    @PostMapping("/updateStatus")
    public ResponseEntity<People>updateStatus()
    {

        People updatestatus=peropleService.updateStatus();

        return new ResponseEntity<>(updatestatus,HttpStatus.OK);
    }
}
