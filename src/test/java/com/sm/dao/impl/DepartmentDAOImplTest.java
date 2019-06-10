package com.sm.dao.impl;

import com.sm.dao.DepartmentDAO;
import com.sm.entity.Department;
import com.sm.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class DepartmentDAOImplTest {
    private DepartmentDAO departmentDAO = DAOFactory.getDepartmentDAOInstance();
    private DepartmentDAO departmentDAO1 = DAOFactory.deleteDepartmentDAOInstance();
    @Test
    public void getAll() {
        List<Department> departmentList = null;
        try {
             departmentList = departmentDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        departmentList.forEach(department -> System.out.println(department));
        }

    @Test
    public void deleteById() {
        try {
            System.out.println(departmentDAO.deleteById(8));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertDepartment() {
        Department department = new Department();
        department.setDepartmentName("Java学院");
        department.setLogo("https://students-manage.oss-cn-beijing.aliyuncs.com/logo/%E8%AE%A1%E7%AE%97%E6%9C%BA.jpg");
        try {
            int n = departmentDAO.insertDepartment(department);
            assertEquals(1,n);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}