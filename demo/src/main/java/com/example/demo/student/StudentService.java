package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {


    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }



    public List<Student> getStudent()
    {
        return studentRepository.findAll();
    }
    public void addNewStudent(Student student)
    {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent())
        {
            throw new IllegalStateException("email is taken");
        }
        //System.out.println(student);
        studentRepository.save(student);
    }


    public void deleteStudent(long studentId) {
boolean exists=studentRepository.existsById(studentId);
if(!exists)
{
    throw new IllegalStateException("Id "+studentId+" not eixts");
}
else
{
    studentRepository.deleteById(studentId);
}
    }
@Transactional
    public void updateStudent(long studentId, String name, String email) {
        Student student=studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("id "+studentId+" does not exixsts"));
        if (name!=null&& !name.isEmpty() &&!Objects.equals(student.getName(),name))
        {
            student.setName(name);
        }
        if (email!=null&& !email.isEmpty() &&!Objects.equals(student.getEmail(),email))
        {
            Optional<Student> studentOptional=studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent())
            {
                throw new IllegalStateException("Email has been taken");
            }
            student.setEmail(email);
        }
    }
}
