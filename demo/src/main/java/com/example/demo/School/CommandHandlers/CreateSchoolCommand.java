package com.example.demo.School.CommandHandlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Command;
import com.example.demo.School.SchoolRepository;
import com.example.demo.School.Model.School;
import com.mysql.cj.util.StringUtils;

@Service
public class CreateSchoolCommand implements Command<School, ResponseEntity> {

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public ResponseEntity execute(School school) {
        
        validateSchool(school);
        
        schoolRepository.save(school);
        return ResponseEntity.ok().build();
    }

    private void validateSchool(School school) {
        if(StringUtils.isNullOrEmpty(school.getName())) {
            throw new RuntimeException("Name cannot be empty");
        }

        if(StringUtils.isNullOrEmpty(school.getDescription())) {
            throw new RuntimeException("Description cannot be empty");
        }

        if(school.getStudents() <= 0) {
            throw new RuntimeException("The number of students cannot negative");
        }

        if(StringUtils.isNullOrEmpty(school.getPhonenumber())) {
            throw new RuntimeException("The phone number cannot be empty");
        }
    }
    
}
