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
    private Double carLength;
    private Double weight;
    private Long weightId;
    private Long goodsTypeId;
    private Long lineTypeId;
    private Date returnTime;
    private Date failureTime;
    private Date createTime;
    private String userName;
    private String phone;
    private String qq;
    private String email;
    private Double price;
    private Long priceId;
    private String goodsName;
    private String mark;
    private Integer status;

}
