package com.cnct.controller;

import com.cnct.pojo.*;
import com.cnct.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    private ConfigService configService;

    @GetMapping("/queryGoodsType")
    public ResponseEntity<List<GoodsType>> queryGoodsType(){
       List<GoodsType> list = goodsTypeService.queryGoodsType();
       return ResponseEntity.ok(list);
    }

    @GetMapping("/queryVehicleType")
    public ResponseEntity<List<VehicleType>> queryVehicleType(){
       List<VehicleType> list = vehicleTypeService.queryVehicleType();
       return ResponseEntity.ok(list);
    }

    @PostMapping("/addCarInfo")
    public ResponseEntity<Void> addCarInfo(CarInfo carInfo){
        carInfoService.addCarInfo(carInfo);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/queryUnit")
    public ResponseEntity<List<Unit>> queryUnit(@RequestParam("status") Integer status){
       List<Unit> list = unitService.queryUnit(status);
       return ResponseEntity.ok(list);
    }

    @PostMapping("/addPost")
    public ResponseEntity<Void> addPost(@RequestBody  Post post){
        postService.addPost(post);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/addPost1")
    public ResponseEntity<Void> a1(Post post){
        postService.addPost(post);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/queryCity")
     public ResponseEntity<List<City>> queryCity(@RequestParam("pid") Long pid){
        List<City> list = cityService.queryCity(pid);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/queryConfig")
    public ResponseEntity<List<Config>> queryConfig(@RequestParam("type") Long type){
        List<Config> list = configService.queryConfig(type);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/queryPost")
    public ResponseEntity<Result> queryPost(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                @RequestParam(value = "rows",defaultValue = "5") Integer rows){
        Result result = postService.queryPost(page,rows);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/deletePost")
    public ResponseEntity<Void> deletePost(@RequestParam("id")Long id){
        postService.deletePost(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/queryPostById")
    public ResponseEntity<Post> queryPostById(@RequestParam("id")Long id){
        Post post = postService.queryPostById(id);
        return ResponseEntity.ok(post);
    }

    @PutMapping("/updatePost")
    public ResponseEntity<Void> updatePost(@RequestBody  Post post){
        postService.updatePost(post);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/updatePost1")
    public ResponseEntity<Void> u1( Post post){
        postService.updatePost(post);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/searchAll")
    public ResponseEntity<Result<Post>> searchAll( @RequestBody Post post,@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                 @RequestParam(value = "rows",defaultValue = "5") Integer rows){
        System.out.println(post);
        Result<Post> result = postService.searchAll(post,page,rows);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/searchAll1")
    public ResponseEntity<Result<Post>> s1(Post post,@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                   @RequestParam(value = "rows",defaultValue = "5") Integer rows){
        System.out.println(post);
        Result<Post> result = postService.searchAll(post,page,rows);
        return ResponseEntity.ok(result);
    }

}
