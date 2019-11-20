package com.cnct.service;

import com.cnct.mapper.PostMapper;
import com.cnct.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostMapper postMapper;

    public void addPost(Post post) {

    }
}
