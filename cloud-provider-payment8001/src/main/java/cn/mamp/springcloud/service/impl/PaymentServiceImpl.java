package cn.mamp.springcloud.service.impl;

import cn.mamp.springcloud.dao.PaymentDao;
import cn.mamp.springcloud.entities.Payment;
import cn.mamp.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mamp
 * @data 2020/4/18
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        
        return paymentDao.getPaymentById(id);
    }
}
