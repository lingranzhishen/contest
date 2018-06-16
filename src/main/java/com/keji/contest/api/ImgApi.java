package com.luglobal.contest.api;


import com.luglobal.contest.enums.ResultCode;
import com.luglobal.contest.exception.CommonException;
import com.luglobal.contest.gson.IntlResultGson;
import com.luglobal.contest.model.ImgInfoDTO;
import com.luglobal.contest.service.ImgService;
import com.luglobal.contest.utils.ConstantHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

@RestController
@RequestMapping("/api/img")
public class ImgApi {

    @Autowired
    private ImgService imgService;

    @PostMapping("upload")
    public Object upload(@RequestParam("file") MultipartFile file) throws Exception{
        IntlResultGson result= imgService.uploadImg(file);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id:.+}")
    public void getFile(@PathVariable Long id, HttpServletResponse httpServletResponse) {
        try {
            ImgInfoDTO dto=imgService.selectImg(id);
            if(dto==null){
                throw new CommonException(ResultCode.BAD_DATA);
            }
            File image = new File(dto.getPath());
            FileInputStream inputStream = new FileInputStream(image);
            int length = inputStream.available();
            byte data[] = new byte[length];
            httpServletResponse.setContentLength(length);
            String fileName = image.getName();
            String fileType = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
            httpServletResponse.setContentType(ConstantHelper.getContentTypeByExpansion(fileType));
            inputStream.read(data);
            OutputStream toClient = httpServletResponse.getOutputStream();
            toClient.write(data);
            toClient.flush();
        } catch (Exception e) {
            throw new CommonException(ResultCode.BAD_DATA);
        }
    }
}
