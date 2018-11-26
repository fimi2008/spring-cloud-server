package top.lionxxw.ribbonservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Package top.lionxxw.ribbonservice.service
 * Project ribbon-service
 *
 * Author lionxxw
 * Created on 2017/5/19 16:11
 * version 1.0.0
 */
@Service
@Slf4j
public class LoadBalanceService {
    @Autowired
    private RestTemplate restTemplate;

    public String testPort(String microserviceName){
        String uri = String.format("http://%s/v1/lbtest/port",microserviceName);
        log.info(uri);
        return restTemplate.getForObject(uri, String.class);
    }

    public String testGetOrderByUserId(String microserviceName, String userId){
        String uri = String.format("http://%s/v1/order/userId=%s",microserviceName, userId);
        log.info(uri);
        return restTemplate.getForObject(uri, String.class);
    }
}
