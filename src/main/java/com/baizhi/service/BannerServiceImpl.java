package com.baizhi.service;

import com.baizhi.dto.BannerPageDto;
import com.baizhi.entity.Banner;
import com.baizhi.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class BannerServiceImpl implements BannerService {
    @Autowired
    BannerMapper bannerMapper;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public BannerPageDto queryByPage(int curPage, int pageSize) {
        BannerPageDto dto = new BannerPageDto();
        // 设置 总行数
        dto.setTotal(bannerMapper.selectTotalCount());
        // 设置 当前页的数据行
        dto.setRows(bannerMapper.selectByPage(curPage, pageSize));
        return dto;
    }

    public void update(Banner banner) {
        bannerMapper.updateByPrimaryKey(banner);
    }


}
