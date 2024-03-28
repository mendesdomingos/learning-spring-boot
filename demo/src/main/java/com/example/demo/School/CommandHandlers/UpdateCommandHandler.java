package com.example.demo.School.CommandHandlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Command;
import com.example.demo.School.SchoolRepository;
import com.example.demo.School.Model.School;
import com.example.demo.School.Model.UpdateSchoolCommand;

@Service
public class UpdateCommandHandler implements Command<UpdateSchoolCommand, ResponseEntity> {

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public ResponseEntity<ResponseEntity> execute(UpdateSchoolCommand command) {
        School school = command.getSchool();
        school.setId(command.getId());
        schoolRepository.save(school);
        return ResponseEntity.ok().build();
    }
    
}
