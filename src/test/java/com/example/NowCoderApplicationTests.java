package com.example;

import com.example.dao.AlphaDao;
import com.example.dao.AlphaDaoMybatisImpl;
import com.example.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = NowCoderApplication.class) //就使用了和主类一样的配置类
class NowCoderApplicationTests implements ApplicationContextAware {
	private ApplicationContext applicationContext;

	@Test
	void contextLoads() {
		System.out.println(applicationContext);
		AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class); //按照类型获取 容器中自动装配的bean 有多个实现的bean的时候会先选择有@Primary注解的
		System.out.println(alphaDao.select());

		alphaDao = (AlphaDao) applicationContext.getBean("alphaMybatis"); //按照名字获取 容器中自动装配的bean，返回的是Object,要强制类型转换
		System.out.println(alphaDao.select());
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		//传入的ApplicationContext就是spring容器的接口 继承了BeanFactory，也就是spring容器的顶接口
		this.applicationContext = applicationContext;//把传入的applicationContext记录，才能在这个类中自己使用
	}

	@Test
	public void beanManage(){
		TestService testService = applicationContext.getBean(TestService.class);
		System.out.println(testService);

		TestService test = applicationContext.getBean(TestService.class);
		System.out.println(test);
	}

	@Autowired
	@Qualifier("alphaMybatis")
	private AlphaDao alphaDao;
}
