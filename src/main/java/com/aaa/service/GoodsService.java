package com.aaa.service;

import com.aaa.pojo.Goods;
import com.aaa.pojo.GoodsVo;
import com.aaa.pojo.SelectGoods;

import java.util.List;

public interface GoodsService {

    //添加书籍
    int insert (Goods goods);

    //修改书籍
    int update (Goods goods);

    //删除商品
    int delete(Integer goodId);

    //查询一个
    GoodsVo QueryOne(int goodId);

    //查询所有书籍
    List<GoodsVo> SelectAll();

    //分页查询
    List<GoodsVo> findBypage(SelectGoods goods);

    //分页查询总条数
    Long findByPageNum(SelectGoods goods);
}
