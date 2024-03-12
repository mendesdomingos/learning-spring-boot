package com.example.demo.School;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.School.Model.School;

@RestController
@RequestMapping("/schools")
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepository;

    @GetMapping
    public ResponseEntity<List<School>> getSchools() {
        return ResponseEntity.ok(schoolRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<School>> getSchool(@PathVariable Integer id) {
        return ResponseEntity.ok(schoolRepository.findById(id));
    }
}
