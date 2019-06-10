package com.sm.service.impl;

import com.sm.entity.RewardPunish;
import com.sm.factory.ServiceFactory;
import com.sm.service.RewardPunishService;
import org.junit.Test;

import java.util.Date;
import java.util.List;


public class RewardPunishServiceImplTest {
    private RewardPunishService rewardPunishService = ServiceFactory.getRewardPunishServiceInstance();

    @Test
    public void selectAll() {
        List<RewardPunish> rewardPunishList = rewardPunishService.selectAll();
        rewardPunishList.forEach(rewardPunish -> System.out.println(rewardPunish));
    }

    @Test
    public void selectByStudentId() {
        List<RewardPunish> rewardPunishList = rewardPunishService.selectByStudentId("1802343323");
        rewardPunishList.forEach(rewardPunish -> System.out.println(rewardPunish));
    }

    @Test
    public void selectRewardByKeywords() {
        List<RewardPunish> rewardPunishList = rewardPunishService.selectByKeywords("叶");
        rewardPunishList.forEach(rewardPunish -> System.out.println(rewardPunish));
    }

    @Test
    public void deleteRewardById() {
        int id = 14;
        int n = rewardPunishService.deleteRewardById(id);
        System.out.println(n);
    }


    @Test
    public void insertReward() {
        RewardPunish rewardPunish = new RewardPunish();
        rewardPunish.setId(15);
        rewardPunish.setStudentId("1802343330");
        rewardPunish.setRpDate(new Date());
        rewardPunish.setEventId(1);
        rewardPunish.setRankId(1);
        int n=rewardPunishService.insertReward(rewardPunish);
    }

}