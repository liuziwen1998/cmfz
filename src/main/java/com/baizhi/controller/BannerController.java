package com.baizhi.controller;

import com.baizhi.dto.BannerPageDto;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        System.out.println(banner);
        bannerService.update(banner);
    }

}
