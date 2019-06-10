package com.sm.service.impl;

import com.sm.dao.CClassDAO;
import com.sm.entity.CClass;
import com.sm.factory.DAOFactory;
import com.sm.service.CClassService;

import java.sql.SQLException;
import java.util.List;

public class CClassServiceImpl implements CClassService {
    private CClassDAO cClassDAO = DAOFactory.getCClassDAOInstance();

    @Override
    public List<CClass> selectByDepartmentId(int departmentId) {
        List<CClass> cClassList = null;
        try {
            cClassList = cClassDAO.selectByDepartmentId(departmentId);
        } catch (SQLException e) {
            System.err.print("根据院系id查找班级出现异常");
        }
        return cClassList;
    }

    /**
     * 删除班级
     *
     * @param id
     * @return
     */
    @Override
    public int deleteClassById(Integer id) {
        int n =0;
        try {
            n = cClassDAO.deleteClassById(id);
        } catch (SQLException e) {
            System.out.println("删除班级出现异常");
        }
        return n;
    }

    /**
     * 新增班级
     * @param cClass
     * @return
     */
    @Override
    public int addClass(CClass cClass) {
        int n = 0;
        try {
            n = cClassDAO.insertClass(cClass);
        } catch (SQLException e) {
            System.out.println("新增班级出现异常");
        }
        return n;
    }

    @Override
    public List<CClass> selectAll() {
        List<CClass> cClassList = null;
        try {
            cClassList = cClassDAO.selectAll();
        } catch (SQLException e) {
           System.out.println("查询所有班级出现异常");
        }
        return cClassList;
    }

    @Override
    public int countByDepartmentId(int departmentId) {
        int n = 0;
        try {
            n = cClassDAO.countByDepartmentId(departmentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }
}
