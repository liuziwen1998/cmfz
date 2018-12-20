package com.baizhi.service;

import com.baizhi.dto.BannerPageDto;
import com.baizhi.entity.Banner;

public interface BannerService {
    public BannerPageDto queryByPage(int curPage, int pageSize);
    public void update(Banner banner);
    public  void insert(Banner banner);
    public  void delete(Banner banner);
}
