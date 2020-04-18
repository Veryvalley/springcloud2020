package cn.mamp.springcloud.controller;

import cn.mamp.springcloud.entities.CommonResult;
import cn.mamp.springcloud.entities.Payment;
import cn.mamp.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author mamp
 * @data 2020/4/18
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    /**
     * 创建订单
     *
     * @param payment 订单内容
     * @return 创建结果
     */
    @PostMapping("/payment/create")
    // post请求,不要忘记 @RequestBody
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("创建结果: {}", result);
        if (result > 0) {
            return new CommonResult(200, "插入成功", result);
        }
        return new CommonResult(444, "插入失败", null);
    }

    /**
     * 查询订单详情
     *
     * @param id 订单ID
     * @return 订单详情
     */
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (null != payment) {
            log.info("id={}的查询结果:{} ", id, payment);
            return new CommonResult(200, "查询成功11", payment);
        }
        return new CommonResult(444, "查询失败", null);
    }
}
