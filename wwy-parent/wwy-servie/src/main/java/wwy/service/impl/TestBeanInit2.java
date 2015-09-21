package wwy.service.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Order(Integer.MIN_VALUE + 100)
@Configuration
public class TestBeanInit2 implements InitializingBean {

	@SuppressWarnings("unused")
	@Autowired
	private TestBeanService testBeanService;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("init2....");
	}

}
