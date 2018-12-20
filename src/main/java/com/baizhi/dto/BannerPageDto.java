package com.baizhi.dto;



import com.baizhi.entity.Banner;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class BannerPageDto implements Serializable {

    private Integer total;
    private List<Banner> rows;


}
