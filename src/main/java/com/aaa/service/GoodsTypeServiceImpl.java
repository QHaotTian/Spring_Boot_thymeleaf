package com.aaa.service;


import com.aaa.mapper.GoodsTypeMapper;
import com.aaa.pojo.GoodsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GoodsTypeService")
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
    GoodsTypeMapper goodsTypeMapper;

    @Override
    public List<GoodsType> SelectAll() {
        return goodsTypeMapper.SelectAll();
    }

    @Override
    public List<GoodsType> SelectOne(int typeId) {
        return goodsTypeMapper.SelectOne(typeId);
    }
}
