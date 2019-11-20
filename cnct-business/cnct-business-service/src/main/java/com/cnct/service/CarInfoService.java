package com.cnct.service;

import com.cnct.mapper.CarInfoMapper;
import com.cnct.pojo.CarInfo;
import com.cnct.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarInfoService {
    @Autowired
    private CarInfoMapper carInfoMapper;

    public void addCarInfo(CarInfo carInfo) {
        carInfoMapper.insert(carInfo);
    }


}
