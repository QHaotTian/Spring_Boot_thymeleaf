package com.aaa.pojo;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Goods {
    private Integer goodsId;
    private String goodsName;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date produceDate;
    private String goodpic;
    private Integer typeId;
}
