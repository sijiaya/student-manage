package com.sm.service;

import com.sm.utils.ResultEntity;

/**
 * AdminService接口,声明adminLogin方法
 */
public interface AdminService {
    ResultEntity adminLogin(String account,String password);
}
