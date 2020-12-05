package com.sonali.srm.service;

import com.sonali.srm.dao.StudentDAO;
import com.sonali.srm.exception.StudentNotFoundException;
import com.sonali.srm.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;


    public Student addStudent(Student student) {
        return studentDAO.save(student);
    }

    public List<Student> getStudents() {
        return studentDAO.findAll();
    }

    public Student getStudent(int studentId) {

        Optional<Student> optionalStudent = studentDAO.findById(studentId);

        if(!optionalStudent.isPresent())
            throw new StudentNotFoundException("Student Record is not available...");

        return optionalStudent.get();
    }

    public Student updateStudent(int studentId, Student student) {
        student.setStudentId(studentId);
        return studentDAO.save(student);
    }

    public void deleteStudent(int studentId) {
        studentDAO.deleteById(studentId);
    }

}

