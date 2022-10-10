package com.SpringAPIBasic;

import com.HibernateUtils.SessionFactoryProvider;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringApiBasicApplication {
	SessionFactory sessionFactory = SessionFactoryProvider.sessionFactoryProviderMethod();
	public static void main(String[] args) {
		SpringApplication.run(SpringApiBasicApplication.class, args);
	}

}
