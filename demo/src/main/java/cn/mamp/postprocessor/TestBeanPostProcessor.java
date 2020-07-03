package cn.mamp.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author mamp
 * @data 2020/7/3
 */
@Component
public class TestBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if("bean1".equalsIgnoreCase(beanName)){
            System.out.println("hahaha: AfterInitialization");
        }
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if("bean1".equalsIgnoreCase(beanName)){
            System.out.println("hahaha: BeforeInitialization");
        }
        return null;
    }


}
