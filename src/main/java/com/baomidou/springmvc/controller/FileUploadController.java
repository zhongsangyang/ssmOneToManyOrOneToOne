package com.baomidou.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
@RequestMapping("/file")
public class FileUploadController{
    @RequestMapping("/upload")
    public void testUpload(HttpServletRequest request,
                           HttpServletResponse response){
        InputStream bis = null;
        try {
            String filename = "下载文件";
            bis = new BufferedInputStream(new FileInputStream(new File("F:\\zip\\AmazeUI-2.7.2.zip")));

            //转码，免得文件名中文乱码
            filename = URLEncoder.encode(filename,"UTF-8");
            //设置文件下载头 假如以中文名下载的话
            response.addHeader("Content-Disposition", "attachment;filename=" + filename);
            //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
            response.setContentType("multipart/form-data");
            BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
            int len = 0;
            while((len = bis.read()) != -1){
                out.write(len);
                out.flush();
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
