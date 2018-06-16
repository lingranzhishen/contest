package com.luglobal.contest.dao;

import com.luglobal.contest.model.UserDTO;

/**
 * Created by lizehua035 on 2018/6/9.
 */
public interface UserDao {
    UserDTO findByUserName(UserDTO user);

    Long insert(UserDTO user);

    UserDTO selectByPrimaryKey(UserDTO user);
}
