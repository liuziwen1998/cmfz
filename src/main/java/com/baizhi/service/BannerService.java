package com.baizhi.service;

import com.baizhi.dto.BannerPageDto;
import com.baizhi.entity.Banner;

public interface BannerService {
    public BannerPageDto queryByPage(int curPage, int pageSize);
    public void update(Banner banner);
}
