package com.example.demoEs_CrudTest.controllers;

import com.example.demoEs_CrudTest.entities.Student;
import com.example.demoEs_CrudTest.models.DTO.StudentDTO;
import com.example.demoEs_CrudTest.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/user")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping()
    public StudentDTO createStudent(@RequestBody StudentDTO user){
        return studentService.createUser(user);
    }

    @GetMapping("/{id}")
    public @ResponseBody Student findById(@PathVariable Long id){
        Student user=  studentService.findById(id);
        if(user != null){
            return user;
        }else{
            return null;
        }
    }
    @GetMapping("/list")
    public List<Student> findAll(){
        return studentService.findALl();
    }
    @PatchMapping("/workingSwitch/{id}")
    public Student workingSwitch(@PathVariable Long id, @RequestParam Boolean working){
        return studentService.isWorkingSwitch(id,working);
    }
    @PatchMapping("/changeInfo/{id}")
    public Student workingSwitch(@PathVariable Long id, @RequestBody StudentDTO user){
        return studentService.changeInfo(id,user);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteUser(id);
        return "Utente " + id + " cancellato";
    }
}
