package cn.mamp.springcloud.service;

import cn.mamp.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author mamp
 * @data 2020/4/18
 */
public interface PaymentService {
    /**
     * 创建订单
     *
     * @param payment 详单实例
     * @return 创建结果
     */
    int create(Payment payment);

    /**
     * 根据订单编号查询订单
     *
     * @param id 订单ID
     * @return 订单实例
     */
    Payment getPaymentById(@Param("id") Long id);
}
