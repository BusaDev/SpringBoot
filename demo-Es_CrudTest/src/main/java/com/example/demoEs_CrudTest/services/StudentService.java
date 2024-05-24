package com.example.demoEs_CrudTest.services;

import com.example.demoEs_CrudTest.Repository.StudentRepo;
import com.example.demoEs_CrudTest.entities.Student;
import com.example.demoEs_CrudTest.models.DTO.StudentDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ModelMapper mapper;

    public StudentDTO createUser (StudentDTO user){
        Student entity = mapper.map(user, Student.class);
        Student saved = studentRepo.saveAndFlush(entity);
        mapper.map(user, saved);
        user.setId(saved.getId());
        return user;
    }
    public Student findById (Long id){
        return studentRepo.findById(id).orElse(null);
    }
    public List<Student> findALl (){
        return studentRepo.findAll();
    }
    public Student isWorkingSwitch(Long id, Boolean working){
        Student findedUser = studentRepo.findById(id).get();
        findedUser.setIsWorking(working);
        studentRepo.saveAndFlush(findedUser);
        return findedUser;
    }
    public Student changeInfo(Long id, StudentDTO user){
        Student findedUser = studentRepo.findById(id).get();
        findedUser.setName(user.getName());
        findedUser.setSurname(user.getSurname());
        studentRepo.saveAndFlush(findedUser);
        return  findedUser;
    }
    public void deleteUser(Long id){
        studentRepo.deleteById(id);
    }
}
