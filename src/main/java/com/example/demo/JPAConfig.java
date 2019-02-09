package com.example.demo;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class JPAConfig {

	@Value("${spring.datasource.driver-class-name}")
	private String DRIVER;
	@Value("${spring.datasource.url}")
	private String DB_URL;
	@Value("${spring.datasource.username}")
	private String DB_USER_NAME;
	@Value("${spring.datasource.password}")
	private String DB_PASSWORD;

	@Bean
	  public LocalContainerEntityManagerFactoryBean factoryBean() {
	      LocalContainerEntityManagerFactoryBean factory =
	              new LocalContainerEntityManagerFactoryBean();
	      factory.setDataSource(getMysqlDataSource());
	      factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
	      //comment the following line if you want to use default META-INF/persistence.xml
	      factory.setPersistenceXmlLocation("persistence.xml");
	      Properties properties = new Properties();
	      factory.setJpaProperties(properties);
	      return factory;
	  }

	/*protected Properties getProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.id.new_generator_mappings", false);
		properties.put("hibernate.connection.datasource", getMysqlDataSource());
		return properties;
	}*/

	

	protected DataSource getMysqlDataSource() {
		DriverManagerDataSource mysqlDataSource = new DriverManagerDataSource();
		mysqlDataSource.setUrl(DB_URL);
		mysqlDataSource.setUsername(DB_USER_NAME);
		mysqlDataSource.setPassword(DB_PASSWORD);
		return mysqlDataSource;
	}

}
