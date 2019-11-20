package com.cnct.service;

import com.cnct.mapper.CityMapper;
import com.cnct.pojo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityMapper cityMapper;

    public List<City> queryCity(Long pid) {
        Example example = new Example(City.class);
        example.createCriteria().andEqualTo("parentid",pid);
        List<City> cities = cityMapper.selectByExample(example);
        return cities;
    }
}
