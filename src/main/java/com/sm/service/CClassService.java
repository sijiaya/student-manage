package com.sm.service;

import com.sm.entity.CClass;
import com.sm.entity.Student;

import java.util.List;

public interface CClassService {
    List<CClass> selectByDepartmentId(int departmentId);

    /**
     * 删除班级
     * @param id
     */
    int deleteClassById(Integer id);

    /**
     * 新增班级
     * @param cClass
     */
    int addClass(CClass cClass);

    /**
     * 查询所有班级
     * @return
     */
    List<CClass> selectAll();


    /**
     * 根据院系id统计班级数
     * @param departmentId
     * @return
     */
    int countByDepartmentId(int departmentId);
}
