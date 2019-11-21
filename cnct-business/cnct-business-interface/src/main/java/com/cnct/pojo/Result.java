package com.cnct.pojo;

import lombok.Data;

import java.util.List;
@Data
public class Result<T> {
    private Long total;
    private Integer page;
    private List<T> posts;
}
