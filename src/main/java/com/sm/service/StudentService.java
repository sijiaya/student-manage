package com.sm.service;

import com.sm.entity.Student;
import com.sm.entity.StudentVO;

import java.util.List;

public interface StudentService {
    /**
     * 查询所有学生
     *
     * @return
     */
    List<StudentVO> selectAll();

    /**
     * 通过院系id查询学生
     *
     * @param departmentId
     * @return
     */
    List<StudentVO> selectByDepartmentId(int departmentId);

    /**
     * 通过班级id查询学生
     *
     * @param classId
     * @return
     */
    List<StudentVO> selectByClassId(int classId);

    /**
     * 模糊查询
     *
     * @param keywords
     * @return
     */
    List<StudentVO> selectByKeywords(String keywords);

    int updateStudent(Student student);

    int deleteById(String id);

    int insertStudent(Student student);

    int countByDepartmentId(int departmentId);

    int countStudentByClassId(int classId);
}

