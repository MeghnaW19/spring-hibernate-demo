package com.stackroute.springdao.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.stackroute.springdao.model.Employee;
//Hibernate configurations

@Configuration
@EnableTransactionManagement
public class ApplicationContextConfig {
	
//	Get A Database Connection , DataSource which is configured with database properties
	
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/myemptestdb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

	
//	Hibernate SessionFactory
	@Bean
	public LocalSessionFactoryBean getSessionFactory(DataSource dataSource) throws IOException {
		
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		
		sessionFactoryBean.setDataSource(dataSource);
		
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		
		sessionFactoryBean.setHibernateProperties(properties);
		sessionFactoryBean.setAnnotatedClasses(Employee.class);
		sessionFactoryBean.afterPropertiesSet();
		
		
		return sessionFactoryBean;
		
		
	}
	
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		
		return transactionManager;
	}
}
