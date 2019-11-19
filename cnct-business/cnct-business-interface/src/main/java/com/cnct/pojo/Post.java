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
    private Long user_id;
    private String start_place;
    private String end_start;
    private Double car_length;
    private Double weight;
    private Long weight_id;
    private Long goodstype_id;
    private Long linetype_id;
    private Date return_time;
    private Date failure_time;
    private Date create_time;
    private String user_name;
    private String phone;
    private String qq;
    private String email;
    private Double price;
    private Long price_id;
    private String goods_name;
    private String mark;
    private Integer status;

}
