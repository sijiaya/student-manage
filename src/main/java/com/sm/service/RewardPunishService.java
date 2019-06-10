package com.sm.service;

import com.sm.entity.RewardPunish;

import java.sql.SQLException;
import java.util.List;

public interface RewardPunishService {
    /**
     * 查询所有学生
     * @return
     */
    List<RewardPunish> selectAll();
    /**
     * 通过班级id查询学生
     * @param studentId
     * @return
     */
    List<RewardPunish> selectByStudentId(String studentId);
    /**
     * 模糊查询
     * @param keywords
     * @return
     */
    List<RewardPunish> selectByKeywords(String keywords);


    /**
     * 根据id删除学生
     * @param id
     * @return
     */
    int deleteRewardById(int id);
    int insertReward(RewardPunish rewardPunish);
}
