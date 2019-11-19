package com.cnct.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Table(name = "tb_car_info")
public class CarInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long carTypeId;
    private Long goodsTypeId;
    private Long count;
    private String lpNumber;
    private String viNumber;
    private String idNumber;
    private String followPhone;
    private String followDriver;


}
