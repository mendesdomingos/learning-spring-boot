package com.example.demo.School;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.School.Model.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {
    
}
