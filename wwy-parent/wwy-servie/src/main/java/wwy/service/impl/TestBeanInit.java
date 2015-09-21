package wwy.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Order(Integer.MIN_VALUE + 1000)
@Configuration
public class TestBeanInit implements InitializingBean, DisposableBean, BeanDefinitionRegistryPostProcessor {

	@SuppressWarnings("unused")
	@Autowired
	private TestBeanService testBeanService;

	public void init() {
		System.out.println("方法初始化!");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("init1....");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy1....");
	}

	// Start:手动注入bean例子
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory paramConfigurableListableBeanFactory)
			throws BeansException {
		Boolean bool = paramConfigurableListableBeanFactory.containsBean("codeBean");
		System.out.println("是否包含codeBean：" + bool);
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry paramBeanDefinitionRegistry)
			throws BeansException {
		BeanDefinition beanDefinition = new RootBeanDefinition();
		beanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);
		beanDefinition.setBeanClassName("test.CodeBean");
		beanDefinition.setAutowireCandidate(true);
		paramBeanDefinitionRegistry.registerBeanDefinition("codeBean", beanDefinition);
	}
	// End:手动注入bean例子
}
