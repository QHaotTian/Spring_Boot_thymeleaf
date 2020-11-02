package com.aaa.service;

import com.aaa.mapper.GoodsMapper;
import com.aaa.pojo.Goods;
import com.aaa.pojo.GoodsVo;
import com.aaa.pojo.SelectGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GoodsService")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public int insert(Goods goods) {
        return goodsMapper.insert(goods);
    }

    @Override
    public int update(Goods goods) {
        return goodsMapper.update(goods);
    }

    @Override
    public int delete(Integer bookId) {
        return goodsMapper.delete(bookId);
    }

    @Override
    public GoodsVo QueryOne(int goodId) {
        return goodsMapper.QueryOne(goodId);
    }

    @Override
    public List<GoodsVo> SelectAll() {
        return goodsMapper.SelectAll();
    }

    @Override
    public List<GoodsVo> findBypage(SelectGoods goods) {
        return goodsMapper.findBypage(goods);
    }

    @Override
    public Long findByPageNum(SelectGoods goods) {
        return goodsMapper.findByPageNum(goods);
    }
}
