package com.xworkz.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.xworkz.app")
public class SpringConfiguration {
    public SpringConfiguration(){

    }
    @Bean
    public LocalContainerEntityManagerFactoryBean getLocalContainerEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setPackagesToScan("com.xworkz.app.Dto");
        bean.setDataSource(getDataSource());
        bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        bean.setJpaProperties(getProperties());
        return bean;
    }

        public Properties getProperties(){
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect , show_sql=true", "org.hibernate.dialect.MySQLDialect");
        return properties;

}

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName("com.mysql.cj.jdbc.Driver");
        source.setPassword("Yashu8904126821");

       source.setUrl("jdbc:mysql://localhost:3306/springUser");
       source.setUsername("root");
      return source;
    }
}
