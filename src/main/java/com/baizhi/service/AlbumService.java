package com.baizhi.service;

import com.baizhi.dto.AlbumPageDto;
import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumService {

    public List<Album> queryAll();

    public AlbumPageDto queryByPage(int curPage, int pageSize);
}
