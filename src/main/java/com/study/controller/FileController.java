package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "file")
public class FileController {

    @RequestMapping(value = "/uploadImage" ,method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String,String> UploadFile(HttpServletRequest request, MultipartFile file){
        String path1 = request.getServletContext().getRealPath("/static/images/ArticleImage");
        String path = "G:/javaWeb/webService/src/main/webapp/static/images/ArticleImage";
        //上传文件名
        String filename = file.getOriginalFilename()+"";
        File filepath = new File(path,filename);
        File filepath1 = new File(path1,filename);
        Map map = new HashMap<String,String>();

        //判断路径是否存在，如果不存在就创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        if (!filepath1.getParentFile().exists()) {
            filepath1.getParentFile().mkdirs();
        }
        try {
            file.transferTo(new File(path + File.separator + filename));
            file.transferTo(new File(path1 + File.separator + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        map.put("url",filename);
        return (HashMap<String, String>) map;
    }
}
