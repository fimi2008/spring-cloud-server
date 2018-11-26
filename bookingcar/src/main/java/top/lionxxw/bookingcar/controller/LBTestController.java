package top.lionxxw.bookingcar.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 负载均衡验证接口
 * Package top.lionxxw.bookingcar.controller
 * Project bookingcar
 *
 * Author lionxxw
 * Created on 2017/5/19 16:02
 * version 1.0.0
 */
@RestController
@RequestMapping("/v1/lbtest")
@Slf4j
public class LBTestController {

    @Value("${server.port}")
    private String port;

    @GetMapping("port")
    public String findServicePort(){
        String prompt = String.format("service running on port:{%s}", port);
        log.info(prompt);
        return prompt;
    }
}
