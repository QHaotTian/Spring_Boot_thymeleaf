package com.aaa.pojo;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class GoodsVo {
    private Integer goodsId;
    private String goodsName;
    private Date produceDate;
    private String goodpic;
    private GoodsType goodsType;
}
