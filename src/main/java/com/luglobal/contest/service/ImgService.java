package com.luglobal.contest.service;


import com.luglobal.contest.dao.ImgInfoDao;
import com.luglobal.contest.enums.ResultCode;
import com.luglobal.contest.exception.CommonException;
import com.luglobal.contest.gson.IntlResultGson;
import com.luglobal.contest.model.ImgInfoDTO;
import com.luglobal.contest.utils.ConstantHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class ImgService {
    @Autowired
    private ImgInfoDao imgInfoDao;

    public ImgInfoDTO insertImg(ImgInfoDTO img) {
        Long id=imgInfoDao.insert(img);
        img.setId(id);
        return img;
    }

    public IntlResultGson uploadImg(MultipartFile file) throws Exception {
        IntlResultGson<ImgInfoDTO> gson=new IntlResultGson();
        ImgInfoDTO imgInfoDTO=new ImgInfoDTO();
        if (!file.isEmpty()) {
            String contentType = file.getContentType();
            String[] imgTypes = {"image/jpeg", "image/gif", "image/jpeg", "image/png"};
            if (StringUtils.endsWithAny(contentType, imgTypes)) {
                String originalFilename = file.getOriginalFilename();
                String suffix = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
                String dateStr = LocalDate.now().toString();
                imgInfoDTO.setOriginName(originalFilename);
                String fileRelativePath = ConstantHelper.ROOT_DIR + dateStr + "/";
                imgInfoDTO.setPath(fileRelativePath + UUID.randomUUID().toString() + suffix);
                imgInfoDTO.setPicSize(file.getSize());
                BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
                imgInfoDTO.setHeight(Long.valueOf(bufferedImage.getHeight()));
                imgInfoDTO.setWidth(Long.valueOf(bufferedImage.getWidth()));
                File targetDir = new File(fileRelativePath);
                if (!targetDir.exists()) {
                    targetDir.mkdirs();
                }
                try {
                    Files.copy(file.getInputStream(), Paths.get(imgInfoDTO.getPath()));
                } catch (IOException | RuntimeException e) {
                    throw new CommonException(ResultCode.UNKNOWN_ERROR);
                }
            }
            insertImg(imgInfoDTO);
            gson.setData(imgInfoDTO);
        }

        return gson;

    }

    public ImgInfoDTO selectImg(Long id) {
        return imgInfoDao.selectById(id);
    }
}
