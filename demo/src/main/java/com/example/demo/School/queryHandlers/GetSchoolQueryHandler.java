package com.example.demo.School.queryHandlers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Query;
import com.example.demo.School.SchoolRepository;
import com.example.demo.School.Model.School;

@Service
public class GetSchoolQueryHandler implements Query<Integer, School> {

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public ResponseEntity<School> execute(Integer id) {
        Optional<School> school = schoolRepository.findById(id);
        if(school.isEmpty()) {
           throw new RuntimeException("Product not found!");
        }
        return ResponseEntity.ok(school.get());
    }

    
}
