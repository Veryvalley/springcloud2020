package cn.mamp.config;

import cn.mamp.bean.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mamp
 * @data 2020/7/3
 */
@Configuration
public class TestConfig {

    @Bean(name = {"bean1", "bean2"}) // bean的别名
    public TestBean testBean() {
        return new TestBean();
    }
}
