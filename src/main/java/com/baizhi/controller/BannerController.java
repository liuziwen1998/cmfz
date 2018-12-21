package com.baizhi.controller;

import com.baizhi.dto.BannerPageDto;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;


@Controller
@RequestMapping("banner")
public class BannerController {
    @Autowired
    BannerService bannerService;
    @RequestMapping("page")
    @ResponseBody
    public BannerPageDto queryByPage(int page, int rows){
        return bannerService.queryByPage(page, rows);
    }

    @RequestMapping("update")
    @ResponseBody
    public void update(Banner banner){

        bannerService.update(banner);
    }


    @RequestMapping("/add")
    @ResponseBody
    public void addSM(MultipartFile img, Banner banner, HttpSession session) throws IOException {
        ServletContext ctx = session.getServletContext();
        String realPath = ctx.getRealPath("/image");
        System.out.println(realPath);
        String oldName = img.getOriginalFilename();
        long time = new Date().getTime();
        String newName= time + oldName;
        // 目标文件
        File descFile = new File(realPath+"/"+ newName);
        // 上传
        img.transferTo(descFile);
        banner.setImgPath("/image/"+ newName);
        session.setAttribute("imgpath", banner.getImgPath());
        bannerService.insert(banner);
    }
    @RequestMapping("delete")
    @ResponseBody
    public void delete(int id) {
        Banner banner = new Banner(id, null, null, null, null, null);
        bannerService.delete(banner);
    }


}
