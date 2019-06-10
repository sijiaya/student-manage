package com.sm.dao.impl;

import com.sm.dao.CClassDAO;
import com.sm.entity.CClass;
import com.sm.utils.JDBCUtil;
import jdk.nashorn.internal.scripts.JD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 班级实现类
 */
public class CClassDAOImpl implements CClassDAO {
    @Override
    public List<CClass> selectByDepartmentId(int departmentId) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT * FROM t_class WHERE department_id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, String.valueOf(departmentId));
        ResultSet rs = pstmt.executeQuery();
        List<CClass> classList = new ArrayList<>();
        while (rs.next()){
            CClass cClass = new CClass();
            cClass.setId(rs.getInt("id"));
            cClass.setDepartmentId(rs.getInt("department_id"));
            cClass.setClassName(rs.getString("class_name"));
            classList.add(cClass);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return classList;
    }

    @Override
    public int insertClass(CClass cClass) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection conn = jdbcUtil.getConnection();
        String sql = "INSERT INTO t_class (department_id,class_name) VALUES (?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,cClass.getDepartmentId());
        pstmt.setString(2,cClass.getClassName());
        int n = pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        return n;
    }


    @Override
    public int deleteClassById(int id) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection conn = jdbcUtil.getConnection();
        String sql = "DELETE FROM t_class WHERE id = " +id;
        PreparedStatement pstmt = conn.prepareStatement(sql);
        int n = pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        return  n;
    }

    /**
     * 封装一个把结果集转成List<CClass>的方法，实现代码复用
     * @param rs
     * @return
     * @throws SQLException
     */
    private List<CClass> convert(ResultSet rs) throws SQLException{
        List<CClass> cClassList = new ArrayList<>();
        while (rs.next()){
            CClass cClass = new CClass();
            cClass.setId(rs.getInt("id"));
            cClass.setDepartmentId(rs.getInt("department_id"));
            cClass.setClassName(rs.getString("class_name"));
            cClassList.add(cClass);
        }
        return cClassList;
    }

    @Override
    public List<CClass> selectAll() throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection conn = jdbcUtil.getConnection();
        //ORDER BY表示默认升序
        String sql = "SELECT * FROM t_class ORDER BY department_id";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<CClass> cClassList = convert(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return cClassList;
    }

    @Override
    public int countByDepartmentId(int departmentId) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection conn = jdbcUtil.getConnection();
        String sql = "SELECT COUNT(*) FROM t_class WHERE department_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,departmentId);
        ResultSet rs = pstmt.executeQuery();
        int rowCount = 0;
        if (rs.next()){
            rowCount = rs.getInt(1);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return rowCount;
    }
}
