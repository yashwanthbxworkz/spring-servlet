package com.xworkz.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.jca.support.LocalConnectionFactoryBean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Properties;

@Component
@ComponentScan(basePackages = "com.xworkz.app")
public class SpringConfiguration {
    public SpringConfiguration(){

    }
    @Bean
    public LocalContainerEntityManagerFactoryBean getLocalContainerEntityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setPackagesToScan("com.xworkz.app.Dto");
        bean.setDataSource(getDataSource());
        bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        bean.setJpaProperties(getProperties());
        return  bean;
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect , show_sql=true", "org.hibernate.dialect.MySQLDialect");
        return properties;

    }

    @Bean
    private DataSource getDataSource() {
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName("com.mysql.cj.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/spring2_userInfo");
        source.setUsername("root");
        source.setPassword("Yashu8904126821");
        return source;
    }
}
