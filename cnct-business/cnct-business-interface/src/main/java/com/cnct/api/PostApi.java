package com.cnct.api;

import com.cnct.pojo.Post;
import com.cnct.pojo.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface PostApi{

    @PutMapping("/updatePost")
    public void updatePost(@RequestBody Post post);

    @GetMapping("/queryPostById")
    public Post queryPostById(@RequestParam("id")Long id);

    @DeleteMapping("/deletePost")
    public void deletePost(@RequestParam("id")Long id);

    @PostMapping("/addPost")
    public void addPost(@RequestBody Post post);

    @GetMapping("/queryPost")
    public Result<Post> queryPost(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                            @RequestParam(value = "rows",defaultValue = "5") Integer rows);

    @PostMapping("/searchAll")
    public Result<Post> searchAll(@RequestBody Post post,@RequestParam(value = "page",defaultValue = "1") Integer page,
                                @RequestParam(value = "rows",defaultValue = "5") Integer rows);
}
