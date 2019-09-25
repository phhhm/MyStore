package config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("repository")
@EnableJpaRepositories("repository")
public class RootConfig {

    @Bean
    public DataSource dataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/store");
        basicDataSource.setUsername("parham");
        basicDataSource.setPassword("123");
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setMaxTotal(20);
        basicDataSource.setMinIdle(10);
        basicDataSource.setMaxWaitMillis(10000);
        return basicDataSource;
    }

//    @Bean
//    public CommonsMultipartResolver multipartResolver(){
//        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
//        commonsMultipartResolver.setMaxUploadSize(1024000);
//        return commonsMultipartResolver;
//    }

    @Bean
    public JpaVendorAdapter vendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        return hibernateJpaVendorAdapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPackagesToScan("model");
        Properties properties = new Properties();
        properties.put("javax.persistence.validation.mode", "none");
        factoryBean.setJpaProperties(properties);
        return factoryBean;
    }

    @Bean
    public PersistenceAnnotationBeanPostProcessor beanPostProcessor(){
        return new PersistenceAnnotationBeanPostProcessor();
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory, DataSource dataSource) {
        JpaTransactionManager jpaTransactionManager =  new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        jpaTransactionManager.setDataSource(dataSource);
        return jpaTransactionManager;
    }
}
