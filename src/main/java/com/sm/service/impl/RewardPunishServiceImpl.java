package com.sm.service.impl;

import com.sm.dao.RewardPunishDAO;
import com.sm.entity.RewardPunish;
import com.sm.factory.DAOFactory;
import com.sm.service.RewardPunishService;

import java.sql.SQLException;
import java.util.List;

public class RewardPunishServiceImpl implements RewardPunishService {
    private RewardPunishDAO rewardPunishDAO = DAOFactory.getRewardPunishInstance();

    @Override
    public List<RewardPunish> selectAll() {
        List<RewardPunish> rewardPunishList = null;
        try {
            rewardPunishList = rewardPunishDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rewardPunishList;
    }

    @Override
    public List<RewardPunish> selectByStudentId(String studentId) {
        List<RewardPunish> rewardPunishList = null;
        try {
            rewardPunishList = rewardPunishDAO.selectByStudentId(studentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rewardPunishList;
    }

    @Override
    public List<RewardPunish> selectByKeywords(String keywords) {
        List<RewardPunish> rewardPunishList = null;
        try {
            rewardPunishList = rewardPunishDAO.selectByKeywords(keywords);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rewardPunishList;
    }

    @Override
    public int deleteRewardById(int id) {
        int n = 0;
        try {
            n = rewardPunishDAO.deleteRewardById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int insertReward(RewardPunish rewardPunish) {
        int n = 0;
        try {
            n = rewardPunishDAO.insertReward(rewardPunish);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }
}
