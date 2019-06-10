package com.sm.dao;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public interface EventDAO {
    /**
     * 查询所有事件
     * @return
     * @throws SQLException
     */
    List<Event> getAll() throws SQLException;

    /**
     * 根据事件id查询
     * @param eventId
     * @return
     * @throws SQLException
     */
    List<Event> selectById(int eventId) throws SQLException;
}
