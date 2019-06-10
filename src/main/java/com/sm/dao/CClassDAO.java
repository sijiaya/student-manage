package com.sm.dao;

import com.sm.entity.CClass;

import java.sql.SQLException;
import java.util.List;

/**
 * 班级DAO接口
 */
public interface CClassDAO {
    /**
     * 按照院系id查询班级
     * @param departmentId
     * @return
     * @throws SQLException
     */
    List<CClass> selectByDepartmentId(int departmentId) throws SQLException;

    /**
     * 新增班级
     * @param cClass
     * @return
     * @throws SQLException
     */
    int insertClass(CClass cClass) throws SQLException;

    /**
     * 根据id删除班级
     * @param id
     * @return
     */
    int deleteClassById(int id) throws SQLException;

    /**
     * 查询所有班级
     * @return
     * @throws SQLException
     */
    List<CClass> selectAll() throws SQLException;

    /**
     * 根据院系id统计班级数
     * @param departmentId
     * @return
     * @throws SQLException
     */
    int countByDepartmentId(int departmentId) throws SQLException;

}
