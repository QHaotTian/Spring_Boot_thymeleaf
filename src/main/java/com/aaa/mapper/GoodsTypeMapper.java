package com.aaa.mapper;

import com.aaa.pojo.GoodsType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GoodsTypeMapper {

    //查询所有类型
    List<GoodsType> SelectAll();

    //查询单个类型
    List<GoodsType> SelectOne(int goodsTypeId);
}
