package com.sm.service.impl;

import com.sm.entity.CClass;
import com.sm.factory.ServiceFactory;
import com.sm.service.CClassService;
import org.junit.Test;

import java.util.List;


public class CClassServiceImplTest {
    private CClassService cClassService = ServiceFactory.getCClassServiceInstance();

    @Test
    public void selectByDepartmentId() {
        List<CClass> cClassList = cClassService.selectByDepartmentId(1);
        cClassList.forEach(cClass -> System.out.println(cClass));
    }

    @Test
    public void deleteClassById() {
        int id = 15;
        cClassService.deleteClassById(id);
    }

    @Test
    public void addClass() {
        CClass cClass = new CClass();
        cClass.setId(32);
        cClass.setDepartmentId(1);
        cClass.setClassName("数控1841");
        cClassService.addClass(cClass);
    }

    @Test
    public void selectAll() {
        List<CClass> cClassList = cClassService.selectAll();
        cClassList.forEach(cClass -> System.out.println(cClass));
    }

    @Test
    public void countByDepartmentId() {
        System.out.println(cClassService.countByDepartmentId(1));
    }
}