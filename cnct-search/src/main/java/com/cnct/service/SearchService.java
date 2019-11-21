package com.cnct.service;

import com.cnct.client.CnctRepository;
import com.cnct.client.PostClient;
import com.cnct.pojo.Post;
import com.cnct.pojo.Result;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    @Autowired
    private CnctRepository cnctRepository;

    @Autowired
    private PostClient postCleint;

    @Autowired
    private ElasticsearchTemplate esTemplate;

    public Result<Post> searchAll(Post post) {
        if(post==null){
            return null;
        }
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        if(!StringUtils.isNotBlank(post.getStartPlace())){
            queryBuilder.withQuery(QueryBuilders.boolQuery() .must( QueryBuilders.termQuery("starPlace", post.getStartPlace()))
                    .must(QueryBuilders.termQuery("endPlace",post.getEndPlace())));
        }
        if(!StringUtils.isNotBlank(post.getEndPlace())){
            queryBuilder.withQuery(QueryBuilders.matchQuery("endPlace",post.getEndPlace()));
        }
        if(StringUtils.isNotBlank(post.getWeight())){
            queryBuilder.withQuery(QueryBuilders.matchQuery("weight",post.getWeight()));
        }
        if(StringUtils.isNotBlank(post.getWeightUnit())){
            queryBuilder.withQuery(QueryBuilders.matchQuery("weightUnit",post.getWeightUnit()));
        }
        if(StringUtils.isNotBlank(post.getGoodsType1())){
            queryBuilder.withQuery(QueryBuilders.matchQuery("goodsType1",post.getGoodsType1()));
        }
        if(StringUtils.isNotBlank(post.getLineType())){
            queryBuilder.withQuery(QueryBuilders.matchQuery("lineType",post.getLineType()));
        }
        if(post.getPrice()!=null){
            queryBuilder.withQuery(QueryBuilders.matchQuery("price",post.getPrice()));
        }
        if(StringUtils.isNotBlank(post.getPriceUnit())){
            String unit = "元/"+post.getPriceUnit();
            queryBuilder.withQuery(QueryBuilders.matchQuery("priceUnit",unit));
        }
//        if(post.getCreateTime()!=null){
//            queryBuilder.withQuery(QueryBuilders.matchQuery("createTime",post.getCreateTime()));
//        }
        Page<Post> search = cnctRepository.search(queryBuilder.build());
        Result<Post> result = new Result<>();
        result.setPosts(search.getContent());
        result.setTotal(search.getTotalElements());
        result.setPage(search.getTotalPages());
        return result;
    }
}
