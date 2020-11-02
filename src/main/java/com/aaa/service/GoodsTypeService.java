package com.aaa.service;


import com.aaa.pojo.GoodsType;

import java.util.List;

public interface GoodsTypeService {
    //查询所有类型
    List<GoodsType> SelectAll();

    //查询单个类型
    List<GoodsType> SelectOne(int typeId);
}
