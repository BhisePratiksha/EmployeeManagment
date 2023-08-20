package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScan("com.spring.jdbc")
public class JdbcConfig {
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		
		DriverManagerDataSource dataSource = 
				new DriverManagerDataSource("jdbc:mysql://localhost/test", "test", "test");
		jdbcTemplate.setDataSource(dataSource);
		
		return jdbcTemplate;
	}
	
	@Bean
	public DataSource setDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/test");
        dataSource.setUsername("test");
        dataSource.setPassword("test");
		
		return dataSource;
		
	}
	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = 
				new NamedParameterJdbcTemplate(setDataSource());
		return namedParameterJdbcTemplate;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		PlatformTransactionManager transactionManager = 
				new DataSourceTransactionManager(setDataSource());
		
		return transactionManager;
	}
}
