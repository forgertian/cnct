package com.cnct.client;

import com.cnct.pojo.Post;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CnctRepository extends ElasticsearchRepository<Post, Long> {
    
}