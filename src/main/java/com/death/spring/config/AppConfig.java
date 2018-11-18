package com.death.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;
import static org.hibernate.cfg.Environment.*;
@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value={
        @ComponentScan("com.death.spring.dao"),
        @ComponentScan("com.death.spring.service")})
public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        Properties properties = new Properties();

        //JDBC properties for session
        properties.put(DRIVER,environment.getProperty("mysql.driver"));
        properties.put(URL,environment.getProperty("mysql.url"));
        properties.put(USER,environment.getProperty("mysql.user"));
        properties.put(PASS,environment.getProperty("mysql.password"));

        //Hibernate properties
        properties.put(SHOW_SQL,environment.getProperty("hibernate.show_sql"));
        properties.put(HBM2DDL_AUTO, environment.getProperty("hibernate.hbm2ddl.auto"));

        //C3P0 properties
        properties.put(C3P0_MIN_SIZE, environment.getProperty("hibernate.c3p0.min_size"));
        properties.put(C3P0_MAX_SIZE, environment.getProperty("hibernate.c3p0.max_size"));
        properties.put(C3P0_ACQUIRE_INCREMENT, environment.getProperty("hibernate.c3p0.acquire_increment"));
        properties.put(C3P0_TIMEOUT, environment.getProperty("hibernate.c3p0.timeout"));
        properties.put(C3P0_MAX_STATEMENTS, environment.getProperty("hibernate.c3p0.max_statements"));

        localSessionFactoryBean.setHibernateProperties(properties);
        localSessionFactoryBean.setPackagesToScan("com.death.spring.model");
        return localSessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager(){
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(getSessionFactory().getObject());
        return hibernateTransactionManager;
    }


}
