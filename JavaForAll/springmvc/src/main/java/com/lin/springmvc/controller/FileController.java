package com.lin.springmvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

/**
 * @program: springmvc
 * @description: 文件上传下载设置
 * @author: linsz
 * @create: 2022-06-28 11:09
 **/
@Controller
public class FileController {

    /**
     * 实现文件的下载功能
     *
     * @return
     */
    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> fileDown(HttpSession session) throws IOException {

        ServletContext context = session.getServletContext();
        String realPath = context.getRealPath("/static/img/1.jpeg");
        FileInputStream is = null;
        is = new FileInputStream(realPath);
        byte[] bytes = new byte[is.available()];
        is.read(bytes);

        //byte[]  header status
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=1.jpeg");

        HttpStatus httpStatus = HttpStatus.OK;
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(bytes, headers, httpStatus);

        is.close();
        return responseEntity;
    }


    @RequestMapping("/testUp")
    public String testFileUp(MultipartFile photo, HttpSession session) throws IOException {

        //获取文件的全名
        String filename = photo.getOriginalFilename();
        //获取文件的后缀
        String suffixName = filename.substring(filename.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String lastFileName = uuid + suffixName;
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("photo");
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdir();
        }
        String finalFileName = realPath + File.separator + lastFileName;

        photo.transferTo(new File(finalFileName));

        return "success";


    }


}
