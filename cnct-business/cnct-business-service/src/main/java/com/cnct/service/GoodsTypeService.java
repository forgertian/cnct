package com.cnct.service;

import com.cnct.mapper.GoodsTypeMapper;
import com.cnct.pojo.GoodsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsTypeService {
    @Autowired
    private GoodsTypeMapper goodsTypeMapper;

    public List<GoodsType> queryGoodsType() {
        return goodsTypeMapper.selectAll();
    }
}
