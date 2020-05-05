package cn.mamp.springcloud.controller;

import cn.mamp.springcloud.entities.CommonResult;
import cn.mamp.springcloud.entities.Payment;
import cn.mamp.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mamp
 * @data 2020/4/18
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 创建订单
     *
     * @param payment 订单内容
     * @return 创建结果
     */
    @PostMapping("/payment/create")
    // post请求,不要忘记 @RequestBody
    public CommonResult create(@RequestBody Payment payment) {
        log.info("ceate payment on [{}]", serverPort);
        int result = paymentService.create(payment);
        log.info("创建结果: {}", result);
        if (result > 0) {
            return new CommonResult(200, "插入成功 on server :" + serverPort, result);
        }
        return new CommonResult(444, "插入失败 on Server : " + serverPort, null);
    }

    /**
     * 查询订单详情
     *
     * @param id 订单ID
     * @return 订单详情
     */
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        log.info("getPaymentById [{}] on server [{}]", id, serverPort);
        Payment payment = paymentService.getPaymentById(id);
        if (null != payment) {
            log.info("id={}的查询结果:{} ", id, payment);
            return new CommonResult(200, "查询成功 on server :" + serverPort, payment);
        }
        return new CommonResult(444, "查询失败 on server :" + serverPort, null);
    }

    /**
     * 服务发现
     *
     * @return
     */
    @GetMapping("/payment/discover")
    public Object discovery() {
        log.info("discovery on  server {}", serverPort);
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("**{}** \r\n", service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("serviceId={} \r\n  instanceId={} \n" +
                    "  hostname = {} \r\n serverPort = {} \r\n uri = {} \r\n", instance.getServiceId(), instance.getInstanceId(), instance.getHost(), instance.getPort(), instance.getUri());
        }
        return this.discoveryClient;
    }
}
