package com.aaa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//条件查询
//条件查询时的总数
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SelectGoods {

    private Integer goodsId;

    private String goodsName;

    private Integer typeId;

    private Integer pageNum;//当前页码

    private Integer pageSize;//每页的条数

    private int start;
}
