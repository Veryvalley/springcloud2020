package cn.mamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

        // bean1和 bean2都是 testBean的别名
        Object obj = ctx.getBean("bean1");
        System.out.println(obj);
        Object obj2 = ctx.getBean("bean2");
        System.out.println(obj2);
        System.out.println(obj == obj2);
        //Object obj3 = ctx.getBean("testBean");
        //System.out.println(obj3);
    }

}
