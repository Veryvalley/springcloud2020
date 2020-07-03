package cn.mamp.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author mamp
 * @data 2020/7/3
 */
public class TestListener implements ApplicationListener {


    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("started....oppppppppp");
    }
}
