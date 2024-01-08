package com.transactiontransferworker.gateway;

import com.transactiontransferworker.gateway.dto.AuthorizationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "authorization-gateway", url = "${gateway.url}")
public interface AuthorizationGateway {

    @GetMapping("/v3/5794d450-d2e2-4412-8131-73d0293ac1cc")
    @ResponseBody
    ResponseEntity<AuthorizationResponse> sendAuthorizationRequest();

}
