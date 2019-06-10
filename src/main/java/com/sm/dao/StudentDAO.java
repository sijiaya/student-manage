package com.sm.dao;

import com.sm.entity.Student;
import com.sm.entity.StudentVO;

import java.sql.SQLException;
import java.util.List;

/**
 * 声明查询所有学生视图对象的方法
 */
public interface StudentDAO {

    /**
     * 查询所有学生（视图对象）
     * @return
     * @throws SQLException
     */
    List<StudentVO> getAll() throws SQLException;

    /**
     * 根据院系id查询学生
     * @param departmentId
     * @return
     * @throws SQLException
     */
    List<StudentVO> selectByDepartmentId(int departmentId) throws SQLException;

    /**
     * 根据班级id查询学生
     * @param classId
     * @return
     * @throws SQLException
     */
    List<StudentVO> selectByClassId(int classId) throws SQLException;

    /**
     * 根据关键词模糊查询
     * @param keywords
     * @return
     * @throws SQLException
     */
    List<StudentVO> selectByKeywords(String keywords) throws SQLException;

    /**
     * 更新学生信息
     * @param student
     * @return
     * @throws SQLException
     */
    int updateStudent(Student student) throws SQLException;

    /**
     * 根据id删除学生
     * @param id
     * @return
     * @throws SQLException
     */
    int deleteById(String id) throws SQLException;

    /**
     * 新增学生
     * @param student
     * @return
     * @throws SQLException
     */
    int insertStudent(Student student) throws SQLException;

    /**
     * 根据院系id统计学生人数
     * @param departmentId
     * @return
     * @throws SQLException
     */
    int countByDepartmentId(int departmentId) throws SQLException;

    /**
     * 根据班级id统计生人数
     * @param classId
     * @return
     * @throws SQLException
     */
    int countByClassId(int classId) throws SQLException;
}
