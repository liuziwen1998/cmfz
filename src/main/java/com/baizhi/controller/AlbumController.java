package com.baizhi.controller;


import com.baizhi.dto.AlbumPageDto;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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

}
