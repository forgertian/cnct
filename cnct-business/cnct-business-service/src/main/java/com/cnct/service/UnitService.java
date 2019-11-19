package com.cnct.service;

import com.cnct.mapper.UnitMapper;
import com.cnct.pojo.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UnitService {

    @Autowired
    private UnitMapper unitMapper;

    public List<Unit> queryUnit(Integer status) {
        switch (status){
            case 0:
                return unitMapper.selectAll();
            case 1:
                Example example = new Example(Unit.class);
                example.createCriteria().andEqualTo("status",0);
                return unitMapper.selectByExample(example);
        }
        return null;
    }
}
