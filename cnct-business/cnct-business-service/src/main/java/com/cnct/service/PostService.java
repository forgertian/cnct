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
        System.out.println(post);
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
        result.setTotal(info.getTotal());
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

    public Result<Post> searchAll(Post post,Integer page,Integer rows) {
        PageHelper.startPage(page,rows);
       Date date = new Date();
        String unit = post.getPriceUnit();
        if(post.getPriceUnit()!=null){
            unit = "元/"+post.getPriceUnit();
        }
        Example example = new Example(Post.class);
        example.createCriteria()
                .andEqualTo("startPlace",post.getStartPlace())
                .andEqualTo("endPlace",post.getEndPlace())
                .andEqualTo("weight",post.getWeight())
                .andEqualTo("weightUnit",post.getWeightUnit())
                .andEqualTo("goodsType1",post.getGoodsType1())
                .andEqualTo("lineType",post.getLineType())
                .andEqualTo("priceUnit",unit)
                .andEqualTo("price",post.getPrice())
                .andBetween("createTime",post.getCreateTime(),date);
        List<Post> list = postMapper.selectByExample(example);
        PageInfo<Post> info = new PageInfo<>(list);
        Result<Post> result = new Result<>();
        result.setPosts(info.getList());
        result.setPage(info.getPages());
        result.setTotal(info.getTotal());
        return result;
    }
}
