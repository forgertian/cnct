package com.cnct.client;

import com.cnct.api.UserAPI;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "user-server")
public interface UserClient extends UserAPI {
}
