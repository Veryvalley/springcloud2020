package cn.mamp.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 测试Aware, 实现Aware接口的类, 在spring 实例或者初始化时,会调用对应的setXXXX方法
 * @author mamp
 * @data 2020/7/3
 */
@Component(value = "applicationAwareBean")
public class ApplicationAwareBean implements ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public ApplicationContext getContext() {
        return context;
    }
}
