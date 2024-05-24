package com.example.demoEs_CrudTest;

import com.example.demoEs_CrudTest.Repository.StudentRepo;
import com.example.demoEs_CrudTest.entities.Student;
import com.example.demoEs_CrudTest.models.DTO.StudentDTO;
import com.example.demoEs_CrudTest.services.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@SpringBootTest
public class ServicesTests {

    @Autowired
    private StudentService studentService;

    @Mock
    private ModelMapper mapper;

    @MockBean
    private StudentRepo studentRepository;

    @Test
    public void testCreateStudent() {
        StudentDTO u = new StudentDTO();
        u.setId(1L);
        u.setName("Davide");
        u.setSurname("Busà");
        u.setIsWorking(true);

        Student student = new Student();
        student.setId(1L);
        student.setName("Davide");
        student.setSurname("Busà");
        student.setIsWorking(true);

        Student saved = new Student();
        saved.setId(1L);
        saved.setName("Davide");
        saved.setSurname("Busà");
        saved.setIsWorking(true);

        when(mapper.map(u, Student.class)).thenReturn(student);
        when(studentRepository.saveAndFlush(any(Student.class))).thenReturn(saved);
        when(mapper.map(saved, StudentDTO.class)).thenReturn(u);

        StudentDTO created = studentService.createUser(u);
        assertEquals("Davide", created.getName());
        assertEquals("Busà", created.getSurname());
    }

    @Test
    public void testGetStudentById() {
        Student u = new Student();
        u.setId(1L);
        u.setName("Davide");
        u.setSurname("Busà");
        u.setIsWorking(true);
        when(studentRepository.findById(1L)).thenReturn(Optional.of(u));
        Student found = studentService.findById(1L);
        assertEquals("Davide", found.getName());
    }

    @Test
    public void testUpdateIsWorking() {
        Student u = new Student();
        u.setId(1L);
        u.setName("Davide");
        u.setSurname("Busà");
        u.setIsWorking(true);
        when(studentRepository.findById(1L)).thenReturn(Optional.of(u));
        when(studentRepository.saveAndFlush(any(Student.class))).thenReturn(u);
        Student updated = studentService.isWorkingSwitch(1L, false);
        assertEquals(false, updated.getisWorking());
    }
}


