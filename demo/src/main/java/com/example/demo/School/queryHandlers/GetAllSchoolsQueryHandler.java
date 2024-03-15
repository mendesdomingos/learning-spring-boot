package com.example.demo.School.queryHandlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.School.SchoolRepository;
import com.example.demo.School.Model.School;

import com.example.demo.Query;

@Service
public class GetAllSchoolsQueryHandler implements Query<Void, List<School>> {

    @Autowired
    private SchoolRepository schoolRepository;
    
    @Override
    public ResponseEntity<List<School>> execute(Void input) {
        return ResponseEntity.ok(schoolRepository.findAll());
    }
}
