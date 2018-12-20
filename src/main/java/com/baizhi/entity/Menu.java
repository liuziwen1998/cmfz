package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import java.util.List;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "menu")

public class Menu implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private  Integer id;
    private  String title;
    private  String iconcls;
    private  String url;
    private  Integer parentId;
    private List<Menu> childrenlist;


}
