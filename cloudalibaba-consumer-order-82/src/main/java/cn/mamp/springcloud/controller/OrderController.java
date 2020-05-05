package cn.mamp.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author mamp
 * @data 2020/5/5
 */
@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.payment}")
    private String servcieUrl;

    @GetMapping("/order/consumer/nacos/{id}")
    public String getOrder(@PathVariable("id") String id) {
        return restTemplate.getForObject(servcieUrl + "/payment/nacos/" + id, String.class);
    }
}
