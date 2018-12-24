package com.baizhi.controller;


import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

@Controller
@RequestMapping("chapter")
public class ChapterController {
    @Autowired
    ChapterService chapterService;


    @RequestMapping("add")
    @ResponseBody
    public void addChapter(MultipartFile music, Chapter chapter, HttpSession session) {
        long size = music.getSize();
        String v = String.valueOf(size / (1024 * 1024.0));
        chapter.setSize(v);
        ServletContext ctx = session.getServletContext();
        String realPath = ctx.getRealPath("music");
        String oldName = music.getOriginalFilename();
        long time = new Date().getTime();
        String newName = time + oldName;
        // 目标文件
        File descFile = new File(realPath + "/" + newName);
        // 上传
        try {
            music.transferTo(descFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        chapter.setUrl("/music/" + newName);
        chapterService.insert(chapter);

    }


    @RequestMapping("/download")
    public void filedownload(String url, String title, HttpSession session, HttpServletResponse response) {
        String realPath = session.getServletContext().getRealPath("/");
        String filePath = realPath + "/" + url;
        File file = new File(filePath);
        String extension = FilenameUtils.getExtension(url);
        String oldName = title + "." + extension;
        String encode = null;
        try {
            encode = URLEncoder.encode(oldName, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setHeader("Content-Disposition", "attachment;fileName=" + encode);
        response.setContentType("audio/mpeg");
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(FileUtils.readFileToByteArray(file));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
