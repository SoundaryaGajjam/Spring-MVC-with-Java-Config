package com.scp.spring.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.journaldev.spring.dao.PersonDAO;
import com.journaldev.spring.dao.PersonDAOImpl;
import com.journaldev.spring.service.PersonService;
import com.journaldev.spring.service.PersonServiceImpl;


@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.journaldev.spring")
public class SpringConfig extends WebMvcConfigurerAdapter{

	 @Bean
	    public ViewResolver viewResolver() {
		 	System.out.println("Inside view Resolver...........");
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setViewClass(JstlView.class);
	        viewResolver.setPrefix("/WEB-INF/views/");
	        viewResolver.setSuffix(".jsp");
	        return viewResolver;
	    }
	    @Override
	    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	    }
	    @Bean //<bean
	    public LocalSessionFactoryBean sessionFactory() {
	    	System.out.println("inside SessionFactory..........");
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();//class
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setPackagesToScan(new String[] {"com.journaldev.spring.model"});
	        sessionFactory.setHibernateProperties(hibernateProperties());
	        return sessionFactory;
	     }
		
	    @Bean
	    public DataSource dataSource() {
	    	System.out.println("Inside data Source...........");
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/scoopen");
	        dataSource.setUsername("root");
	        dataSource.setPassword("root");
	        return dataSource;
	    }
	    
	    private Properties hibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	        properties.put("hibernate.show_sql", true);
	        properties.put("hibernate.format_sql", true);
	        properties.put("hibernate.hbm2ddl.auto", "create-drop");
	        return properties;        
	    }
	    
	    @Bean
	    public HibernateTransactionManager transactionManager(
	            SessionFactory sessionFactory) {
	        HibernateTransactionManager tm = new HibernateTransactionManager(
	        		sessionFactory);
	        return tm;
	    }
	    
	  /*  @Bean
	    public PersonDAO daoImpl(){
	    	System.out.println("inside dao");
	    	return new PersonDAOImpl();
	    }

	    @Bean
	    public PersonService serviceImpl(){
	    	System.out.println("inside service");
	    	return new PersonServiceImpl();
	    }
	   */
}
