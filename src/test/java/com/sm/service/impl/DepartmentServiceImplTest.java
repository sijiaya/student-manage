package com.sm.service.impl;

import com.sm.entity.Department;
import com.sm.factory.ServiceFactory;
import com.sm.service.DepartmentService;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class DepartmentServiceImplTest {

    private DepartmentService departmentService = ServiceFactory.getDepartmentServiceInstance();

    @Test
    public void selectAll() {
        List<Department> departmentList = departmentService.selectAll();

        departmentList.forEach(department -> System.out.println(department));
    }

    @Test
    public void deleteById() {
        int id = 8;
        departmentService.deleteById(id);
    }

    @Test
    public void addDepartment() {
        Department department = new Department();
        department.setId(10);
        department.setDepartmentName("测试一下");
        department.setLogo("https://students-manage.oss-cn-beijing.aliyuncs.com/logo/%E8%B4%B8%E6%98%93.jpg");
        departmentService.addDepartment(department);
    }

    @Test
    public void selectDepartmentInfo() {
        List<Map> mapList = departmentService.selectDepartmentInfo();
        mapList.forEach(map -> {
            System.out.println(map.get("department"+","+map.get("classCount")+"个班,"+map.get("studentCount")+"个学生"));
        });
    }
}