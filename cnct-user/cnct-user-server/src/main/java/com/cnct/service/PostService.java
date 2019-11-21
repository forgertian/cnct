package com.cnct.service;

import com.cnct.client.PostClient;
import com.cnct.pojo.Post;
import com.cnct.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostClient postClient;
    public void addPost(Post post) {
        postClient.addPost(post);
    }

    public void deletePost(Long id) {
        postClient.deletePost(id);
    }

    public void updatePost(Post post) {
        postClient.updatePost(post);
    }

    public Result<Post> searchAll(Post post, Integer page, Integer rows) {
        Result<Post> list = postClient.searchAll(post, page, rows);
        return list;
    }
}
