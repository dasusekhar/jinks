package com.example.CrudeApplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "TBL_PEOPLE")
public class People {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private LocalDateTime dateTime;

    private boolean status;

}
