package com.keji.contest.service;


import com.alibaba.fastjson.JSON;
import com.keji.contest.config.UserContext;
import com.keji.contest.dao.ImgInfoDao;
import com.keji.contest.dao.UserIdentityDao;
import com.keji.contest.enums.IdentityStatusEnums;
import com.keji.contest.enums.ImgTypeEnums;
import com.keji.contest.enums.ResultCode;
import com.keji.contest.exception.CommonException;
import com.keji.contest.gson.*;
import com.keji.contest.model.ImgInfoDTO;
import com.keji.contest.model.UserDTO;
import com.keji.contest.model.UserIdentityDTO;
import org.apache.catalina.startup.UserConfig;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class IdentityService {
    @Autowired
    private UserIdentityDao userIdentityDao;


    public IntlResultGson addTask(String param) {
        param=URLDecoder.decode(param);

        IntlResultGson gson = new IntlResultGson();
        IdentityReqGson req = JSON.parseObject(param, IdentityReqGson.class);
        UserDTO user = UserContext.getUser();
        UserIdentityDTO identityDto = userIdentityDao.selectByUserId(user.getUserId());
        if (identityDto == null) {
            identityDto = new UserIdentityDTO();
            identityDto.setStatus(IdentityStatusEnums.NEW.name());
            identityDto.setUserId(user.getUserId());
        }
        if (ImgTypeEnums.FACE.name().equals(req.getType())) {
            identityDto.setFaceImgId(req.getImgId());
        } else if (ImgTypeEnums.HAND_IMG.name().equals(req.getType())) {
            identityDto.setHandImgId(req.getImgId());
        } else if (ImgTypeEnums.PASSPORT.name().equals(req.getType())) {
            identityDto.setPassportImgId(req.getImgId());
        } else {
            throw new CommonException(ResultCode.BAD_DATA);
        }
        if (identityDto.getId() == null) {
            userIdentityDao.insert(identityDto);
        } else {
            userIdentityDao.updateSelective(identityDto);
        }
        return gson;
    }

    public IntlResultGson listTask(IdentityListReqGson reqGson) {
        IntlResultGson gson = new IntlResultGson();
        long totalCount = userIdentityDao.countUserIdentity();
        PaginationGson<UserIdentityDTO> paginationGson = new PaginationGson<UserIdentityDTO>(totalCount, reqGson.getPage());
        Map<String, Object> map = new HashMap<>();
        map.put("offset", paginationGson.getOffset());
        map.put("limit", paginationGson.getLimit());
        List<UserIdentityDTO> data = userIdentityDao.listIdentity(map);
        paginationGson.setData(data);
        gson.setData(paginationGson);
        return gson;
    }

    public IntlResultGson approveIdentity(IdentityApproveGson req) {
        IntlResultGson gson = new IntlResultGson();
        UserIdentityDTO identityDto = userIdentityDao.selectByUserId(req.getUserId());
        if (identityDto == null) {
            throw new CommonException(ResultCode.NOT_EXIST);
        }
        if (IdentityStatusEnums.PASS.name().equals(req.getResult())) {
            //TODO
        } else {

        }
        identityDto.setStatus(req.getResult());
        identityDto.setMemo(req.getMemo());
        identityDto.setCreatedBy(UserContext.getUser().getUsername());
        userIdentityDao.updateSelective(identityDto);
        return gson;
    }

    public IntlResultGson detail(Long id) {
        IntlResultGson gson = new IntlResultGson();
        UserIdentityDTO identityDto = userIdentityDao.selectByUserId(id);
        gson.setData(identityDto);
        return gson;
    }

}
