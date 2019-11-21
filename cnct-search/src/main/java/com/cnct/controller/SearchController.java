package com.cnct.controller;

import com.cnct.pojo.Post;
import com.cnct.pojo.Result;
import com.cnct.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @PostMapping("/searchAll")
    public ResponseEntity<Result<Post>> searchAll( Post post){
        System.out.println(post);
        Result<Post> result = searchService.searchAll(post);
        return ResponseEntity.ok(result);
     }
}
