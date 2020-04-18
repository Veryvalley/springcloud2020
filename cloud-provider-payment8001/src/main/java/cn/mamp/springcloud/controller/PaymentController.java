package cn.mamp.springcloud.controller;

import cn.mamp.springcloud.entities.CommonResult;
import cn.mamp.springcloud.entities.Payment;
import cn.mamp.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mamp
 * @data 2020/4/18
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;


    @PostMapping("/payment/create")
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("创建结果: {}", result);
        if (result > 0) {
            return new CommonResult(200, "插入成功", result);
        }
        return new CommonResult(400, "插入失败", null);
    }

    @GetMapping("/payment/get/{id}")
    public Payment getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (null != payment) {
            log.info("id={}的查询结果:{} ", id, payment);
            return payment;
        }
        return null;
    }
}
