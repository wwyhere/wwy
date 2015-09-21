package service.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import kafka.producer.ProducerConfig;
import test.BaseSpringTest;
import test.CodeBean;
import wwy.service.TestService;
import wwy.service.impl.TestBean;
import wwy.service.impl.TestImportAware;

@SuppressWarnings("unused")
public class TestBeanService extends BaseSpringTest {

	@Autowired
	private TestService testService;

	@Autowired
	private TestBean testBean;

	@Autowired
	private ProducerConfig producerConfig;

	@Autowired
	private TestImportAware testImportAware;

	@Test
	public void test() {
		System.out.println(producerConfig);
		// System.out.println(new Config().getTestConstants());
		// System.out.println("author:" + testImportAware.getAuthor());
		// System.out.println("version:" + testImportAware.getVersion());
		// System.out.println(testBean.getName());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext.xml", "classpath:spring/applicationContext-redis.xml");
		System.out.println(applicationContext);
		RedisTemplate redisTemplate = (RedisTemplate) applicationContext.getBean("redisTemplate");
		if (redisTemplate.hasKey("list")) {
			redisTemplate.delete("list");
		}
		if (redisTemplate.hasKey("user.userid.1")) {
			redisTemplate.delete("user.userid.1");
		}
		if (redisTemplate.hasKey("hash")) {
			redisTemplate.delete("hash");
		}
		System.out.println(redisTemplate.opsForValue().get("name"));
		CodeBean bean = applicationContext.getBean("codeBean", CodeBean.class);// 获取代码注入的bean
		System.out.println(bean);

		System.out.println(applicationContext.getEnvironment().getProperty("constants.testConstants"));
	}
}
