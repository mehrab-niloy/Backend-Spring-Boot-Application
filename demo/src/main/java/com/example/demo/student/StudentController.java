package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping(path = "api/v1/Student")
public class StudentController {

private final StudentService studentservice;

@Autowired
    public StudentController(StudentService studentservice) {
        this.studentservice = studentservice;
    }
    @GetMapping

    public List<Student> getStudent()
    {
        return studentservice.getStudent();
    }

@PostMapping
public void registerNewStudent(@RequestBody Student student)
{
    studentservice.addNewStudent(student);
}
@DeleteMapping(path = "{studentId}")
public void deleteStudent(@PathVariable("studentId") long studentId)
{
studentservice.deleteStudent(studentId);
}
@PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email)

{
studentservice.updateStudent(studentId,name,email);
}

}

