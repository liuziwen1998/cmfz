package com.baizhi.service;

import com.baizhi.dto.AlbumPageDto;
import com.baizhi.entity.Album;
import com.baizhi.mapper.AlbumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumMapper albumMapper;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public AlbumPageDto queryByPage(int curPage, int pageSize) {
        AlbumPageDto dto = new AlbumPageDto();
        // 设置 总行数
        dto.setTotal(albumMapper.selectTotalCount());
        // 设置 当前页的数据行
        dto.setRows(albumMapper.selectByPage(curPage, pageSize));
        return dto;
    }


    public List<Album> queryAll() {
        List<Album> list = albumMapper.queryAll();
        return list;
    }


}
