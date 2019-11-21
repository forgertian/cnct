package com.cnct.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank(message = "手机号不能为空！")
  @Pattern(regexp = "^1[35678]\\d{9}$", message = "手机号格式不正确")
  private String phone;
  @JsonIgnore
  private String password;
  private String name;
  private Long gender;
  @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$",message = "邮箱格式不正确")
  private String email;
  private String companyName;

  @Pattern(regexp = "^1[35678]\\d{9}$", message = "手机号格式不正确")
  private String refPhone;
  private Long roleId;
  private Long isLicompany;
  private Long isIntlicompany;
  private Long isShipping;
  private Long isRailTransport;
  private Long isAirTransport;
  private String otherWay;
  private String weichatNo;
  private String qqNo;
  private String image;
  private Long province;
  private String provinceName;
  private Long city;
  private String cityName;
  private Long district;
  private String districtName;
  private String address;
  private Long goodsType;
  private Long isStart;
  private java.sql.Date createDate;
  private Long isVip;
  private java.sql.Date vipEndTime;
  private Long bannedStatus;

  public User(Long id,Long bannedStatus){
    this.id = id;
    this.bannedStatus = bannedStatus;
  }
}
