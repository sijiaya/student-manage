package com.sm.dao.impl;

import com.sm.dao.RewardPunishDAO;
import com.sm.entity.RewardPunish;
import com.sm.utils.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RewardPunishDAOImpl implements RewardPunishDAO {
    @Override
    public List<RewardPunish> getAll() throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection conn = jdbcUtil.getConnection();
        String sql = "SELECT t1.id,t4.department_name,t3.class_name,t2.student_name,t5.event,t6.rank,t1.punish_date\n" +
                "FROM t_reward_punishment t1\n" +
                "LEFT JOIN t_student t2\n" +
                "ON t1.student_id = t2.id\n" +
                "LEFT JOIN t_class t3\n" +
                "ON t2.class_id = t3.id\n" +
                "LEFT JOIN t_department t4\n" +
                "ON t3.department_id = t4.id\n" +
                "LEFT JOIN t_event t5 ON t1.event_id= t5.id\n" +
                "LEFT JOIN t_rank t6 ON t1.rank_id = t6.id";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<RewardPunish> rewardPunishList = convert(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return rewardPunishList;
    }

    @Override
    public List<RewardPunish> selectByStudentId(String studentId) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection conn = jdbcUtil.getConnection();
        String sql = "SELECT t1.id,t4.department_name,t3.class_name,t2.student_name,t5.event,t6.rank,t1.punish_date\n" +
                "FROM t_reward_punishment t1\n" +
                "LEFT JOIN t_student t2\n" +
                "ON t1.student_id = t2.id\n" +
                "LEFT JOIN t_class t3\n" +
                "ON t2.class_id = t3.id\n" +
                "LEFT JOIN t_department t4\n" +
                "ON t3.department_id = t4.id\n" +
                "LEFT JOIN t_event t5 ON t1.event_id= t5.id\n" +
                "LEFT JOIN t_rank t6 ON t1.rank_id = t6.id\n" +
                "WHERE t2.id LIKE ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,studentId);
        ResultSet rs = pstmt.executeQuery();
        List<RewardPunish> rewardPunishList = convert(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return rewardPunishList;
    }

    @Override
    public List<RewardPunish> selectByKeywords(String keywords) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection conn = jdbcUtil.getConnection();
        String sql = "\n" +
                "SELECT t1.id,t4.department_name,t3.class_name,t2.student_name,t5.event,t6.rank,t1.punish_date\n" +
                "FROM t_reward_punishment t1\n" +
                "LEFT JOIN t_student t2\n" +
                "ON t1.student_id = t2.id\n" +
                "LEFT JOIN t_class t3\n" +
                "ON t2.class_id = t3.id\n" +
                "LEFT JOIN t_department t4\n" +
                "ON t3.department_id = t4.id\n" +
                "LEFT JOIN t_event t5 ON t1.event_id= t5.id\n" +
                "LEFT JOIN t_rank t6 ON t1.rank_id = t6.id\n" +
                "WHERE t2.student_name LIKE ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,"%" + keywords + "%");
        ResultSet rs = pstmt.executeQuery();
        List<RewardPunish> rewardPunishList = convert(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return rewardPunishList;
    }

    @Override
    public int deleteRewardById(int id) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection conn = jdbcUtil.getConnection();
        String sql = "DELETE FROM t_reward_punishment WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,id);
        int n = pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        jdbcUtil.closeConnection();
        return n;
    }

    @Override
    public int insertReward(RewardPunish rewardPunish) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection conn = jdbcUtil.getConnection();
        String sql = "INSERT INTO t_reward_punishment VALUES (?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,rewardPunish.getId());
        pstmt.setString(2,rewardPunish.getStudentId());
        pstmt.setDate(3, new Date(rewardPunish.getRpDate().getTime()));
        pstmt.setInt(4,rewardPunish.getEventId());
        pstmt.setInt(5,rewardPunish.getRankId());
        int n = pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        jdbcUtil.closeConnection();
        return n;
    }

    private List<RewardPunish> convert(ResultSet rs) throws SQLException{
        List<RewardPunish> rewardPunishList = new ArrayList<>();
        while (rs.next()) {
            RewardPunish rewardPunish = new RewardPunish();
            rewardPunish.setId(rs.getInt("id"));
            rewardPunish.setDepartmentName(rs.getString("department_name"));
            rewardPunish.setClassName(rs.getString("class_name"));
            rewardPunish.setStuName(rs.getString("student_name"));
            rewardPunish.setEvent(rs.getString("event"));
            rewardPunish.setRank(rs.getString("rank"));
            rewardPunish.setRpDate(rs.getDate("punish_date"));
            rewardPunishList.add(rewardPunish);
        }
        return rewardPunishList;
    }
}
