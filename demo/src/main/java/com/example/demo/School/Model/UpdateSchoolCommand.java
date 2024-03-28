package com.example.demo.School.Model;

import lombok.Data;

@Data
public class UpdateSchoolCommand {
    private int id;
    private School school;
    
    public UpdateSchoolCommand(int id, School school) {
        this.id = id;
        this.school = school;
    }
}
