package com.baizhi.entity;


import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "album")

public class Album implements Serializable {
    @Id
    @ExcelIgnore
    private Integer id;
    @Excel(name = "专辑名称")
    private String title;
    @Excel(name = "集数")
    private int count;
    @Excel(name = "封面图", type = 2, width = 40, height = 20, imageType = 1)
    private String coverImg;
    @Excel(name = "评分")
    private String score;
    @Excel(name = "作者")
    private String author;
    @Excel(name = "播音员")
    private String broadcast;
    @Excel(name = "简介")
    private String brief;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @Excel(name = "发布日期", format = "YYYY年MM月dd日", width = 20)
    private Date pubDate;
    @ExcelCollection(name = "包含章节")
    @Transient
    private List<Chapter> children;


}
