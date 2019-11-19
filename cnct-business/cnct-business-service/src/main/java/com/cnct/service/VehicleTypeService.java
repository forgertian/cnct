package com.cnct.service;

import com.cnct.mapper.VehicleTypeMapper;
import com.cnct.pojo.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleTypeService {
    @Autowired
    private VehicleTypeMapper vehicleTypeMapper;

    public List<VehicleType> queryVehicleType() {
        return vehicleTypeMapper.selectAll();
    }
}
