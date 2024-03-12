package com.example.demo.controllers;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schools")
public class SchoolController {

    @GetMapping
    public ResponseEntity getSchool() {
        return ResponseEntity.status(HttpStatus.OK).body(Collections.emptyList());
    }
}
