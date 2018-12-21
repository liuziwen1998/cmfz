package com.baizhi.dto;


import com.baizhi.entity.Album;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AlbumPageDto implements Serializable {

    private Integer total;
    private List<Album> rows;


}
