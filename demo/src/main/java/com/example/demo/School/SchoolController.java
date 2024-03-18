package com.example.demo.School;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.School.Model.School;
import com.example.demo.School.queryHandlers.GetAllSchoolsQueryHandler;
import com.example.demo.School.queryHandlers.GetSchoolQueryHandler;

@RestController
@RequestMapping("/schools")
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private GetAllSchoolsQueryHandler getAllSchoolsQueryHandler;

    @Autowired
    private GetSchoolQueryHandler getSchoolQueryHandler;

    @GetMapping
    public ResponseEntity<List<School>> getSchools() {
        return getAllSchoolsQueryHandler.execute(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<School> getSchool(@PathVariable Integer id) {
        return getSchoolQueryHandler.execute(id);
    }

    @PostMapping
    public ResponseEntity createSchool(@RequestBody School school) {
        schoolRepository.save(school);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateSchool(@PathVariable Integer id, @RequestBody School school) {
        school.setId(id);
        schoolRepository.save(school);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSchool(@PathVariable Integer id) {
        School school = schoolRepository.findById(id).get();
        schoolRepository.delete(school);
        return ResponseEntity.ok().build();
    }
}
