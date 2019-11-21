package com.cnct.service;

import com.cnct.CnctSearchService;
import com.cnct.client.CnctRepository;
import com.cnct.client.PostClient;
import com.cnct.pojo.Post;
import com.cnct.pojo.Result;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CnctSearchService.class)
public class FirstTest {

    @Autowired
    private PostClient postClient;

    @Autowired
    private CnctRepository cnctRepository;

    @Autowired
    private ElasticsearchTemplate esTemplate;

    @Test
    public void test1(){
        // 创建索引
        this.esTemplate.createIndex(Post.class);
        // 配置映射
        this.esTemplate.putMapping(Post.class);
    }
    @Test
    public void test2(){
        this.esTemplate.deleteIndex(Post.class);
    }
    @Test
    public void test3(){
        int page = 1;
        int rows = 5;
        while(page<3){
            Result<Post> result = postClient.queryPost(page, rows);
            List<Post> posts = result.getPosts();
            cnctRepository.saveAll(posts);
            page++;
        }
    }
    @Test
    public void test4(){
        String endPlace = "长沙";
        Double price = 23.5;
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.withQuery(QueryBuilders.termQuery("endPlace",endPlace));
        queryBuilder.withQuery( QueryBuilders.termQuery("price", price));
        Page<Post> search = cnctRepository.search(queryBuilder.build());
        List<Post> content = search.getContent();
        content.forEach(System.out::println);
    }
}
