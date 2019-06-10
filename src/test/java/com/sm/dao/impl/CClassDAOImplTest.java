package com.sm.dao.impl;

import com.sm.dao.CClassDAO;
import com.sm.entity.CClass;
import com.sm.entity.Department;
import com.sm.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class CClassDAOImplTest {
    private CClassDAO cClassDAO = DAOFactory.getCClassDAOInstance();

    /**
     * 按照院系id查找班级
     */
    @Test
    public void selectByDepartmentId() {
        List<CClass> cClassList = null;
        try {
            cClassList = cClassDAO.selectByDepartmentId(5);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cClassList.forEach(cClass -> System.out.println(cClass));
    }

    @Test
    public void insertClass() {
        CClass cClass = new CClass();
        cClass.setDepartmentId(6);
        cClass.setClassName("动漫1841");
        try {
            int n =cClassDAO.insertClass(cClass);
            assertEquals(1,n);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void deleteClassById() {
        try {
            System.out.println(cClassDAO.deleteClassById(8));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectAll() {
        List<CClass> cClassList = null;
        try {
            cClassList = cClassDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cClassList.forEach(cClass -> System.out.println(cClass));
    }

    @Test
    public void countByDepartmentId() {
        try {
            System.out.println(cClassDAO.countByDepartmentId(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}