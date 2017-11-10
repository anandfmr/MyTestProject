package com.example.demo;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@SpringBootApplication
public class HelloWorldApplication {
    @Configuration
    @EntityScan("com.book.healthapp.domain")
    @EnableTransactionManagement
    @PropertySource("classpath:application.properties")
    public class AppConfig { 
 
       @Value("${spring.datasource.driver-class-name}") String driverClassName;
       @Value("${spring.datasource.url}") String url;
       @Value("${spring.datasource.username}") String username;
       @Value("${spring.datasource.password}") String password;
 
       @Bean(name = "dataSource")
       public DataSource getDataSource() {
         DataSource dataSource = DataSourceBuilder
           .create()
           .username(username)
           .password(password)
           .url(url)
           .driverClassName(driverClassName)
           .build();
           return dataSource;
       }
 
       @Bean(name = "sessionFactory")
         public SessionFactory getSessionFactory(DataSource dataSource) {
           LocalSessionFactoryBuilder sessionBuilder = new 
             LocalSessionFactoryBuilder(dataSource);
           sessionBuilder.scanPackages("com.book.healthapp.domain");
           return sessionBuilder.buildSessionFactory();
       }
 
       @Bean(name = "transactionManager")
       public HibernateTransactionManager getTransactionManager(
         SessionFactory sessionFactory) {
           HibernateTransactionManager transactionManager = new   
             HibernateTransactionManager(sessionFactory);
           return transactionManager;
         }
       } 
    @RequestMapping("/")
    String home() { 
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }
}