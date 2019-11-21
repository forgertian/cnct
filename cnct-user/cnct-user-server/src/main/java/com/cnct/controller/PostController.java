package com.cnct.controller;

import com.cnct.pojo.Post;
import com.cnct.pojo.Result;
import com.cnct.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @PutMapping("/updatePost")
    public ResponseEntity<Void> updatePost(Post post){
        postService.updatePost(post);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/deletePost")
    public ResponseEntity<Void> deletePost(@RequestParam("id")Long id){
        postService.deletePost(id);
        return ResponseEntity.ok(null);
    }
    @PostMapping("/addPost")
    public ResponseEntity<Void> addPost(Post post){
        System.out.println(post);
        postService.addPost(post);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/searchAll")
    public ResponseEntity<Result<Post>> searchAll(Post post, @RequestParam(value = "page",defaultValue = "1") Integer page,
                                                  @RequestParam(value = "rows",defaultValue = "5") Integer rows){
        System.out.println(post);
        Result<Post> result = postService.searchAll(post,page,rows);
        return ResponseEntity.ok(result);
    }

}
