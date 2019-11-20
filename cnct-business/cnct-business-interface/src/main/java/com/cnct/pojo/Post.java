package com.cnct.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "tb_post")
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String startPlace;
    private String endPlace;
    private String carLength;
    private String weight;
    private String weightUnit;
    private String goodsType1;
    private String goodsType2;
    private String lineType;
    private Date returnTime;
    private Date failureTime;
    private Date createTime;
    private String userName;
    private String phone;
    private String qq;
    private String email;
    private Integer isCar;
    private String price;
    private String priceUnit;
    private String goodsName;
    private String mark;
    private Integer status;
    private Integer count;
}
