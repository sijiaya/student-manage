package com.sm.service.impl;

import com.sm.entity.Student;
import com.sm.entity.StudentVO;
import com.sm.factory.ServiceFactory;
import com.sm.service.StudentService;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class StudentServiceImplTest {
    private StudentService studentService = ServiceFactory.getStudentServiceInstance();
    @Test
    public void selectAll(){
        List<StudentVO> studentList = studentService.selectAll();
        studentList.forEach(student -> System.out.println(student));
    }
    @Test
    public void selectByClassId(){
        List<StudentVO> studentList = studentService.selectByClassId(5);
        studentList.forEach(studentVO -> System.out.println(studentVO));
    }
    @Test
    public void updateStudent() {
        Student student = new Student();
        student.setId("1802343323");
        student.setAddress("山西大同");
        student.setPhone("133333");
        studentService.updateStudent(student);
    }

    @Test
    public void deleteById() {
        String id = "123";
        int n=   studentService.deleteById(id);
        System.out.println(n);
    }

    @Test
    public void insertStudent() {
        Student student = new Student();
        student.setId("1802343329");
        student.setClassId(19);
        student.setStudentName("尤长靖");
        student.setAvatar("https://students-manage.oss-cn-beijing.aliyuncs.com/logo/33.jpg");
        student.setBirthday(new Date());
        student.setGender("男");
        student.setAddress("马来西亚");
        student.setPhone("12336273221");
        studentService.insertStudent(student);
    }

    @Test
    public void countByDepartmentId() {
        System.out.println(studentService.countByDepartmentId(1));
    }

    @Test
    public void countStudentByClassId() {
        System.out.println(studentService.countStudentByClassId(1));
    }
}