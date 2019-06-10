package com.sm.dao.impl;

import com.sm.dao.StudentDAO;
import com.sm.entity.Student;
import com.sm.entity.StudentVO;
import com.sm.factory.DAOFactory;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StudentDAOImplTest {
    private StudentDAO studentDAO  = DAOFactory.getStudentDAOInstance();
    @Test
    public void selectAll() {
        List<StudentVO> studentList = null;
        try {
            studentList = studentDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        studentList.forEach(studentVO -> System.out.println(studentVO));
    }

    @Test
    public void selectByDepartmentId() {
        List<StudentVO> studentList = null;
        try {
            studentList = studentDAO.selectByDepartmentId(5);
            if (studentList != null){
                System.out.println(studentList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectByClassId() {
        List<StudentVO> studentList = null;
        try {
            studentList = studentDAO.selectByClassId(18);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (studentList != null){
            System.out.println(studentList);
        }
    }

    @Test
    public void selectByKeywords() {
        List<StudentVO> studentList = null;
        try {
            studentList = studentDAO.selectByKeywords("江");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        studentList.forEach(studentVO -> System.out.println(studentVO));
    }

    @Test
    public void updateStudent() throws SQLException{
        Student student = new Student();
        student.setId("1802343301");
        student.setAddress("山东青岛");
        student.setPhone("1369999999");
        int  n = studentDAO.updateStudent(student);
        assertEquals(1,n);
    }

    @Test
    public void deleteById() throws SQLException{
        int n = studentDAO.deleteById("1802343321");
        assertEquals(1,n);
    }

    @Test
    public void insert() throws SQLException{
        Student student = new Student();
        student.setId("1802343328");
        student.setClassId(16);
        student.setStudentName("嘉弈");
        student.setAvatar("https://students-manage.oss-cn-beijing.aliyuncs.com/logo/avatar4.jpg");
        student.setBirthday(new Date());
        student.setGender("男");
        student.setAddress("四川成都");
        student.setPhone("13452562172");
        int n  = studentDAO.insertStudent(student);
        assertEquals(1,n);
    }

    @Test
    public void countByDepartmentId() {
        try {
            System.out.println(studentDAO.countByDepartmentId(7));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void countByClassId() {
        try {
            System.out.println(studentDAO.countByClassId(23));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}