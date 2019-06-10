package com.sm.dao.impl;

import com.sm.dao.RewardPunishDAO;
import com.sm.entity.RewardPunish;
import com.sm.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class RewardPunishDAOImplTest {
    private RewardPunishDAO rewardPunishDAO = DAOFactory.getRewardPunishInstance();

    @Test
    public void getAll() {
        List<RewardPunish> rewardPunishList = null;
        try {
            rewardPunishList = rewardPunishDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        rewardPunishList.forEach(rewardPunish -> System.out.println(rewardPunish));
    }

    @Test
    public void selectByStudentId() {
        List<RewardPunish> rewardPunishList = null;
        try {
            rewardPunishList = rewardPunishDAO.selectByStudentId("1802343309");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rewardPunishList != null){
            System.out.println(rewardPunishList);
        }
    }

    @Test
    public void selectByKeywords() {
        List<RewardPunish> rewardPunishList = null;
        try {
            rewardPunishList = rewardPunishDAO.selectByKeywords("学");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        rewardPunishList.forEach(rewardPunish -> System.out.println(rewardPunish));
    }

    @Test
    public void deleteRewardById() throws SQLException{
        int n = rewardPunishDAO.deleteRewardById(14);
        assertEquals(1,n);
    }


    @Test
    public void insertReward()throws SQLException {
        RewardPunish rewardPunish = new RewardPunish();
        rewardPunish.setId(14);
        rewardPunish.setStudentId("1802343329");
        rewardPunish.setRpDate(new Date());
        rewardPunish.setEventId(1);
        rewardPunish.setRankId(1);
        int n=rewardPunishDAO.insertReward(rewardPunish);

    }
}