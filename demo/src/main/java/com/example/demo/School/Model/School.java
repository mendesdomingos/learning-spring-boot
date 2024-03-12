package com.example.demo.School.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "school")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "students")
    private Integer students;

    @Column(name = "phonenumber")
    private String phonenumber;
}
