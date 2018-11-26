package top.lionxxw.ribbonservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lionxxw.ribbonservice.service.LoadBalanceService;

/**
 * Package top.lionxxw.ribbonservice.controller
 * Project ribbon-service
 *
 * Author lionxxw
 * Created on 2017/5/19 16:18
 * version 1.0.0
 */
@RestController
@RequestMapping("/v1/lb")
@Slf4j
public class LoadBalanceController {

    @Autowired
    LoadBalanceService lbService;

    @GetMapping("/testport")
    public String testPort(String name) {
        String response = lbService.testPort(name);
        log.info(response);
        return response;
    }
}
