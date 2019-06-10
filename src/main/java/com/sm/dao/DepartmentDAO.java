package com.sm.dao;

import com.sm.entity.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDAO {
    /**
     * 查询所有院系
     * @return List<Department>
     * @throws SQLException
     */
    List<Department> getAll() throws SQLException;

    /**
     * 删除院系
     * @param id
     * @return
     * @throws SQLException
     */
    int deleteById(Integer id) throws SQLException;

    /**
     * 新增院系
     * @param department
     * @return
     * @throws SQLException
     */
    int insertDepartment(Department department) throws SQLException;

}
