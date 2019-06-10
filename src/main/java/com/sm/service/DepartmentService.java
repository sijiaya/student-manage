package com.sm.service;

import com.sm.entity.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    List<Department> selectAll();

    /**
     * 删除院系
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 新增院系
     * @param department
     * @return
     */
    int addDepartment(Department department);

    /**
     * 获取所有院系的完整信息（学院自身信息，班级数，学生数）
     * @return
     */
    List<Map> selectDepartmentInfo();
}
