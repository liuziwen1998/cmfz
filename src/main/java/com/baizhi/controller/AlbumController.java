package com.baizhi.controller;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.dto.AlbumPageDto;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("queryAll")
    @ResponseBody
    public AlbumPageDto queryAll(int page, int rows) {
        return albumService.queryByPage(page, rows);
    }


    @RequestMapping("add")
    @ResponseBody
    public void addAlbum(MultipartFile img, Album album, HttpSession session) throws IOException {
        ServletContext ctx = session.getServletContext();
        String realPath = ctx.getRealPath("/image");
        String oldName = img.getOriginalFilename();
        long time = new Date().getTime();
        String newName = time + oldName;
        // 目标文件
        File descFile = new File(realPath + "/" + newName);
        // 上传
        img.transferTo(descFile);
        album.setCoverImg("/image/" + newName);
        albumService.insert(album);
    }


    @RequestMapping("export")
    public void export(HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("content-Type", "application/vnd.ms-excel");
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("easypoi", "UTF-8") + ".xls");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        response.setCharacterEncoding("UTF-8");
        String realPath = request.getSession().getServletContext().getRealPath("/");


        List<Album> list = albumService.queryAll();
        for (Album album : list) {
            album.setCoverImg(realPath + album.getCoverImg());
        }

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("专辑", "章节"), Album.class, list);

        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
