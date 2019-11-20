package com.cnct.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_city")
public class City {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long parentid;
    private String shortname;
    private String leveltype;
    private String citycode;
    private String zipcode;
    private String lng;
    private String lat;
    private String pinyin;
    private String status;

}
