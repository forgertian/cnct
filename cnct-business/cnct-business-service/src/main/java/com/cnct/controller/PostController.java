package com.cnct.controller;

import com.cnct.pojo.CarInfo;
import com.cnct.pojo.GoodsType;
import com.cnct.pojo.Unit;
import com.cnct.pojo.VehicleType;
import com.cnct.service.CarInfoService;
import com.cnct.service.GoodsTypeService;
import com.cnct.service.UnitService;
import com.cnct.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private GoodsTypeService goodsTypeService;

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @Autowired
    private CarInfoService carInfoService;

    @Autowired
    private UnitService unitService;

    @GetMapping("post/queryGoodsType")
    public ResponseEntity<List<GoodsType>> queryGoodsType(){
       List<GoodsType> list = goodsTypeService.queryGoodsType();
       return ResponseEntity.ok(list);
    }

    @GetMapping("post/queryVehicleType")
    public ResponseEntity<List<VehicleType>> queryVehicleType(){
       List<VehicleType> list = vehicleTypeService.queryVehicleType();
       return ResponseEntity.ok(list);
    }

    @PostMapping("post/addCarInfo")
    public ResponseEntity<Void> addCarInfo(CarInfo carInfo){
        carInfoService.addCarInfo(carInfo);
        return ResponseEntity.ok(null);
    }

    @GetMapping("post/queryUnit")
    public ResponseEntity<List<Unit>> queryUnit(@RequestParam("status") Integer status){
       List<Unit> list = unitService.queryUnit(status);
       return ResponseEntity.ok(list);
    }

}
