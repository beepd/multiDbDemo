package com.multi.db.demo.multiDbDemo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "secondryEntityManagerFactory",
        transactionManagerRef = "secondryTransactionManager",
        basePackages = { "com.multi.db.demo.multiDbDemo.dao.secondry" }
)
public class SecondryDatabaseConfig {

    @Bean(name = "secondryDataSource")
    @ConfigurationProperties(prefix = "bar.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                       @Qualifier("secondryDataSource") DataSource dataSource) {

        return builder.dataSource(dataSource)
                .packages("com.multi.db.demo.multiDbDemo.model.secondry")
                .persistenceUnit("bar")
                .build();
    }

    @Bean(name = "secondryTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("secondryEntityManagerFactory")EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }
}
