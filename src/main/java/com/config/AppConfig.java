package com.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan("com")
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class AppConfig {

    @Autowired
    private Environment env;

    @Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public DataSource dataSource() {

        // CREATE CONNECTION POOL
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        // SET JDBC DRIVER
        try {
            dataSource.setDriverClass(env.getProperty("jdbc.driver"));
        } catch(PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        // SET CONNECTION PROPERTIES
        dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        dataSource.setUser(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));

        // SET CONNECTION POOL PROPERTIES
        dataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.initialPoolSize")));
        dataSource.setMinPoolSize(Integer.parseInt(env.getProperty("connection.pool.minPoolSize")));
        dataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("connection.pool.maxPoolSize")));
        dataSource.setMaxIdleTime(Integer.parseInt(env.getProperty("connection.pool.maxIdleTime")));

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(@Value("${hibernate.dialect}") String dialect, DataSource ds) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(ds);
        sessionFactory.setPackagesToScan("com.model");
        Properties cfg = new Properties();
        cfg.setProperty("hibernate.dialect", dialect);
        cfg.setProperty("hibernate.show_sql", "true");
        sessionFactory.setHibernateProperties(cfg);
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sf) {
        HibernateTransactionManager tx = new HibernateTransactionManager();
        tx.setSessionFactory(sf);
        return tx;
    }
}
