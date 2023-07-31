package com.lingfenglong.features;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@SpringBootApplication
public class Boot306FeaturesApplication {
	public static void main(String[] args) {
		// 1
//		SpringApplication.run(Boot306FeaturesApplication.class, args);

		// 2
		// 自定义application的设置，配置文件properties优先级更高
//		SpringApplication application = new SpringApplication(Boot306FeaturesApplication.class);
//		application.setBannerMode(Banner.Mode.CONSOLE);
//		application.run(args);

		// 3 流式调用
		ConfigurableApplicationContext context = new SpringApplicationBuilder()
//				.main(Boot306FeaturesApplication.class)
				.sources(Boot306FeaturesApplication.class)
				.bannerMode(Banner.Mode.OFF)
				.run(args);

		try {
			System.out.println("当前环境：" + context.getBean("dev"));
		} catch (Exception e) {}

		try {
			System.out.println("当前环境：" + context.getBean("test"));
		} catch (Exception e) {}

		try {
			System.out.println("当前环境：" + context.getBean("prod"));
		} catch (Exception e) {}

		try {
			System.out.println("当前环境：" + context.getBean("devTools"));
		} catch (Exception e) {}

		try {
			System.out.println("当前环境：" + context.getBean("testTools"));
		} catch (Exception e) {}

		System.out.println(context.getEnvironment().getProperty("env"));
	}

}
