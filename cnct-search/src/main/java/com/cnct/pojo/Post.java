package com.cnct.pojo;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Document(indexName = "post", type = "docs", shards = 1, replicas = 0)
public class Post {
    @Id
    private Long id;
    private Long userId;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String startPlace;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String endPlace;
//    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String carLength;
//    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String weight;
    private String carType;
//    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String weightUnit;
//    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String goodsType1;
//    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String goodsType2;
//    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String lineType;
    private Date returnTime;
    private Date failureTime;
    private Date createTime;
//    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String userName;
//    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String phone;
    private String qq;
    private String email;
    private Integer isCar;
    private Double price;
//    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String priceUnit;
//    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String goodsName;
    private String mark;
    private Integer status;
    private Integer count;
}
