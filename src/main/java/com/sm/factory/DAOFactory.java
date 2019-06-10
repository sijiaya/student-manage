package com.sm.factory;

import com.sm.dao.*;
import com.sm.dao.impl.*;

/**
 * 获取DAO实例
 */
public class DAOFactory {
    public static AdminDAO getAdminDAOInstance(){
        return new AdminDAOImpl();
    }
    public static DepartmentDAO getDepartmentDAOInstance(){
        return new DepartmentDAOImpl();
    }
    public static DepartmentDAO deleteDepartmentDAOInstance(){
        return new DepartmentDAOImpl();
    }
    public static DepartmentDAO insertDepartmentDAOInstance(){
        return new DepartmentDAOImpl();
    }
    public static CClassDAO getCClassDAOInstance(){
        return new CClassDAOImpl();
    }
    public static CClassDAO deleteCClassDAOInstance(){
        return new CClassDAOImpl();
    }
    public static CClassDAO insertCClassDAOInstance(){
        return new CClassDAOImpl();
    }
    public static StudentDAO getStudentDAOInstance(){ return new StudentDAOImpl(); }

    public static RewardPunishDAO getRewardPunishInstance(){
        return new RewardPunishDAOImpl();
    }

}
