package com.sonali.srm.dao;

import com.sonali.srm.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDAO extends CrudRepository<Student, Integer> {

    @Override
    List<Student> findAll();

}