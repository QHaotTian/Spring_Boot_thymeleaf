package com.aaa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    //总条数 -- 总共有多少条数据
    private Integer total;
    //每一页显示的行数
    private Object rows;
}
