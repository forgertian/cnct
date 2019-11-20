package com.cnct.controller;

import com.cnct.pojo.*;
import com.cnct.service.*;
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

    @Autowired
    private PostService postService;

    @Autowired
    private CityService cityService;

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

//    @PostMapping("post/addPost")
////    public ResponseEntity<Void> addPost(Post post){
////        postService.addPost();
////        return ResponseEntity.ok(null);
//    }

    @GetMapping("post/queryCity")
     public ResponseEntity<List<City>> queryCity(@RequestParam("pid") Long pid){
        List<City> list = cityService.queryCity(pid);
        return ResponseEntity.ok(list);
    }
}
