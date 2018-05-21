package org.spring.resources.test;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

public class JunitTestBase {
	private ClassPathXmlApplicationContext context;
	private String springXmlPath;

	/**
	 * 无参构造器，使用此构造器则使用默认spring配置文件
	 */
	public JunitTestBase() {

	}

	/**
	 * 含参构造器，初始化spring配置文件路径
	 *
	 * @param springXmlPath
	 *            spring配置文件路径
	 */
	public JunitTestBase(String springXmlPath) {
		super();
		this.springXmlPath = springXmlPath;
	}

	/**
	 * 加载spring配置文件到容器中，并启动容器 在@Test方法执行之前执行
	 */
	@Before
	public void before() {

		if (StringUtils.isEmpty(springXmlPath)) {// 默认spring配置文件
			springXmlPath = "classpath:spring_*.xml";
		}
		// 加载spring配置文件到spring容器中
		context = new ClassPathXmlApplicationContext(springXmlPath.split("[,\\s]+"));
		// 启动spring容器，并将启动信号扩散器该容器下的所有组件中
		context.start();

	}

	/**
	 * 销毁Spring容器 在@Test方法执行之后执行
	 */
	@After
	public void after() {

		if (context != null) {
			context.destroy();
		}

	}

	/**
	 * 通过bean Id获取对象
	 *
	 * @param beanId
	 *            bean id
	 * @return
	 */
	public Object getBean(String beanId) {

		return context.getBean(beanId);

	}
}
