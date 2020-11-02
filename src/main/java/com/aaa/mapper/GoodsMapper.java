package com.aaa.mapper;

import com.aaa.pojo.Goods;
import com.aaa.pojo.GoodsVo;
import com.aaa.pojo.SelectGoods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GoodsMapper {

    //添加商品
    int insert (Goods goods);

    //修改商品
    int update (Goods goods);

    //删除商品
    int delete(Integer goodsId);

    //批量删除
    int deletes(int goodsId[]);

    //查询一个
    GoodsVo QueryOne(int goodId);

    //查询所有书籍
    List<GoodsVo> SelectAll();

    //分页查询
    List<GoodsVo> findBypage(SelectGoods goods);

    //分页查询总条数
    Long findByPageNum(SelectGoods goods);
}
