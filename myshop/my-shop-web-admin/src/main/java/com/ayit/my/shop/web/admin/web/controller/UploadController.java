package com.ayit.my.shop.web.admin.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class UploadController {

    private static final String PATH_UPLOAD="/static/upload/";
    @ResponseBody
    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public Map<String, Object> upload(MultipartFile dropzFile, MultipartFile editorFile, HttpServletRequest request){
        Map<String, Object> result = new HashMap<>();

//        判断是处理Dropzone还是wangditor
        MultipartFile myFile = dropzFile == null ? editorFile:dropzFile;

        // 获取上传的原始文件名
        String fileName = myFile.getOriginalFilename();
        // 设置文件上传路径
        String filePath = request.getSession().getServletContext().getRealPath(PATH_UPLOAD);
        // 获取文件后缀
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());

        // 判断并创建上传用的文件夹
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }
        // 重新设置文件名为 UUID，以确保唯一
        file = new File(filePath, UUID.randomUUID() + fileSuffix);

        try {
            // 写入文件
            myFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 返回 JSON 数据，这里只带入了文件名
//    此时处理的是Dropzone传过来的值
        if(dropzFile != null){
            result.put("fileName", "http://localhost:8080"+PATH_UPLOAD+file.getName());
        }
//        此时处理的是wangditor传递过来的值
        else{
            String serverPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
            result.put("errno",0);
            result.put("data",new String[]{serverPath+PATH_UPLOAD + file.getName()});
        }

        return result;
    }


}
