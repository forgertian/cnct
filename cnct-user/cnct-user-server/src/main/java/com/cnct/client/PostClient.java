package com.cnct.client;


import com.cnct.api.PostApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "business-server")
public interface PostClient extends PostApi{
}
