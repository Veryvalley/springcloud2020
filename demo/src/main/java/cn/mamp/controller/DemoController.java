package cn.mamp.controller;

import cn.mamp.bean.ApplicationAwareBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mamp
 * @data 2020/7/3
 */
@RestController
@RequestMapping("/test")
public class DemoController {
    @Resource(name = "applicationAwareBean")
    private ApplicationAwareBean context;

    @RequestMapping("/context")
    public void testContext() {
        Object obj = context.getContext().getBean("bean1");
        System.out.println(obj);
    }
}
