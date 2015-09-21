package boot;

import org.springframework.boot.SpringApplication;

import controller.TestController;

/**
 * 快速启动单个或多个controller的web应用<br>
 * 〈功能详细描述〉
 *
 * @author weiyi.wang
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Object[] {TestController.class}, args);
    }
}
