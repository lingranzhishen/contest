package com.keji.contest.dao;

import com.keji.contest.model.UserIdentityDTO;

import java.util.List;
import java.util.Map;

/**
 * Created by lizehua035 on 2018/6/9.
 */
public interface UserIdentityDao {

    UserIdentityDTO selectByUserId(Long userId);

    void insert(UserIdentityDTO identityDto);

    void updateSelective(UserIdentityDTO identityDto);

    long countUserIdentity();

    List<UserIdentityDTO> listIdentity(Map<String,Object> param);
}
