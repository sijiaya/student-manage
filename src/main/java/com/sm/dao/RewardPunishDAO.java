package com.sm.dao;

import com.sm.entity.RewardPunish;

import java.sql.SQLException;
import java.util.List;

public interface RewardPunishDAO {
    List<RewardPunish> getAll() throws SQLException;

    List<RewardPunish> selectByStudentId(String studentId)throws SQLException;
    List<RewardPunish> selectByKeywords(String keywords)throws SQLException;
    int deleteRewardById(int id) throws SQLException;
    int insertReward(RewardPunish rewardPunish) throws SQLException;
}
