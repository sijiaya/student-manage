package com.sm.service.impl;

import com.sm.dao.StudentDAO;
import com.sm.entity.Student;
import com.sm.entity.StudentVO;
import com.sm.factory.DAOFactory;
import com.sm.service.StudentService;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO = DAOFactory.getStudentDAOInstance();

    @Override
    public List<StudentVO> selectAll() {
        List<StudentVO> studentList = null;
        try {
            studentList = studentDAO.getAll();
        } catch (SQLException e) {
            System.out.println("查询所有学生信息出现异常");
        }
        return studentList;
    }

    @Override
    public List<StudentVO> selectByDepartmentId(int departmentId) {
        List<StudentVO> studentList = null;
        try {
            studentList = studentDAO.selectByDepartmentId(departmentId);
        } catch (SQLException e) {
            System.out.println("根据学院id查询学生信息出现异常");
        }
        return studentList;
    }

    @Override
    public List<StudentVO> selectByClassId(int classId) {
        List<StudentVO> studentList = null;
        try {
            studentList = studentDAO.selectByClassId(classId);
        } catch (SQLException e) {
            System.out.println("根据班级id查询学生信息出现异常");
        }
        return studentList;
    }

    @Override
    public List<StudentVO> selectByKeywords(String keywords) {
        List<StudentVO> studentList = null;
        try {
            studentList = studentDAO.selectByKeywords(keywords);
        } catch (SQLException e) {
            System.out.println("模糊查询学生信息出现异常");
        }
        return studentList;
    }

    @Override
    public int updateStudent(Student student) {
        int n = 0;
        try {
            n = studentDAO.updateStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int deleteById(String id) {
        int n = 0;
        try {
            n = studentDAO.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int insertStudent(Student student) {
        int n = 0;
        try {
            n = studentDAO.insertStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int countByDepartmentId(int departmentId) {
        int n = 0;
        try {
            n = studentDAO.countByDepartmentId(departmentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int countStudentByClassId(int classId) {
        int n = 0;
        try {
            n = studentDAO.countByClassId(classId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

}
