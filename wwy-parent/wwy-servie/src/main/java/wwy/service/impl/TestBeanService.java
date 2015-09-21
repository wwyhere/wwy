package wwy.service.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestBeanService {
	
	@Bean
	public TestBean getTestBean(){
		TestBean bean=new TestBean();
		bean.setName("abc");
		return bean;
	}
}
