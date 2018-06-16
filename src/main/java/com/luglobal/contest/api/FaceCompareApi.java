package com.luglobal.contest.api;

import com.alibaba.fastjson.JSON;
import com.luglobal.contest.enums.ResultCode;
import com.luglobal.contest.gson.IntlResultGson;
import com.luglobal.contest.model.req.FaceCompareReq;
import com.luglobal.contest.service.FaceCompareService;
import com.luglobal.contest.service.ImgService;
import com.luglobal.contest.utils.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/face")
public class FaceCompareApi {

    @Autowired
    private FaceCompareService faceCompareService;
    @Autowired
    private HttpServletRequest servletRequest;
    @PostMapping("compare")
    public Object upload(@RequestParam("param") String param) throws Exception{
        FaceCompareReq req = JSON.parseObject(param, FaceCompareReq.class);
        Tuple.Tuple2<ResultCode, Object>  result= faceCompareService.hModelFaceCompare(req, servletRequest);
        return JSON.toJSONString(result);
    }

}
