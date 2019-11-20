package com.cnct.service;

import com.cnct.mapper.PostMapper;
import com.cnct.pojo.Post;
import com.cnct.pojo.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostMapper postMapper;

    public void addPost(Post post) {
        post.setStatus(1);
        post.setCreateTime(new Date());
        post.setPriceUnit("元/"+ post.getPriceUnit());
        if(post.getCount()!=null){
            post.setIsCar(1);
        }else{
            post.setIsCar(0);
        }
        postMapper.insert(post);
    }

    public Result queryPost(Integer page,Integer rows) {
        PageHelper.startPage(page,rows);
        Example example = new Example(Post.class);
        example.setOrderByClause("create_time DESC");
        List<Post> posts = postMapper.selectByExample(example);
        PageInfo<Post> info = new PageInfo<>(posts);
        Result<Post> result = new Result<>();
        result.setPosts(info.getList());
        result.setPage(info.getPages());
        int total = (int)info.getTotal();
        result.setTotal(total);
        return result;
    }

    public void deletePost(Long id) {
        int i = postMapper.deleteByPrimaryKey(id);
    }

    public Post queryPostById(Long id) {
        Post post = postMapper.selectByPrimaryKey(id);
        return post;
    }

    public void updatePost(Post post) {
        Post post1 = postMapper.selectByPrimaryKey(post.getId());
        post.setCreateTime(post1.getCreateTime());
        post.setStatus(post1.getStatus());
        post.setIsCar(post1.getIsCar());
        postMapper.updateByPrimaryKey(post);
    }
}
