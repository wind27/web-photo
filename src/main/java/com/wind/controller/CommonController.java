package com.wind.controller;

import com.wind.common.Constant.FileSize;
import com.wind.common.Constant.RequestStatusCode;
import com.wind.common.Constant.RequestStatusMsg;
import com.wind.common.Meta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/")
public class CommonController {
    private final static Logger logger = LoggerFactory.getLogger(CommonController.class);

    @RequestMapping(value = "/user/image", method = RequestMethod.GET)
    public ModelAndView visitAllFeedForPage() {
        return new ModelAndView("/user/image");
    }

    /**
     * 上传图片
     * 
     * @param request request
     * @return 返回结果
     */
    @ResponseBody
    @RequestMapping(value = "/upload/img", method = RequestMethod.POST)
    public Object imageUpload(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        Meta meta = new Meta();
        MultipartFile multipartFile;
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            multipartFile = multipartRequest.getFile("file");
            Random random = new Random();
            int num = random.nextInt(999999);
            File file = new File("/wind/image/" + num + ".jpg");
            while (file.exists()) {
                num = random.nextInt(999999);
                file = new File("/wind/image/" + num + ".jpg");
            }
            multipartFile.transferTo(file);

            if (file.length() > FileSize.IMAGE_MAX_SIZE) {
                meta.setCode(RequestStatusCode.FILE_UPLOAD_ERROR);
                meta.setMsg(RequestStatusMsg.FILE_UPLOAD_ERROR);
                resultMap.put("meta", meta);
                return resultMap;
            }

            System.out.println(file.length());
            meta.setCode(RequestStatusCode.SUCCESS);
            meta.setMsg(RequestStatusMsg.SUCCESS);
            resultMap.put("meta", meta);
            return resultMap;
        } catch (Exception e) {
            meta.setCode(RequestStatusCode.PARAMS_ERROR);
            meta.setMsg(RequestStatusMsg.PARAMS_ERROR);
            resultMap.put("meta", meta);
            return resultMap;
        }
    }

}
