package com.polygon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AppLoader {

	private static final ApplicationContext ctx = SpringApplication.run(AppLoader.class, new String[]{});
	private static final Object lock = new Object();

	public static void main(String[] args) throws InterruptedException {
		synchronized (lock) {
			while (ctx == null) {
				Thread.sleep(10);
			}
		}
	}

	public static <T> T get(Class<T> clazz) {
		synchronized (lock) {}
		return ctx.getBean(clazz);
	}

}
