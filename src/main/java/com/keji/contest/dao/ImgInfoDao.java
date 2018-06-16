package com.keji.contest.dao;

import com.keji.contest.model.ImgInfoDTO;

/**
 * Created by lizehua035 on 2018/6/9.
 */
public interface ImgInfoDao {
    long insert(ImgInfoDTO img);

    ImgInfoDTO selectById(Long id);
}
