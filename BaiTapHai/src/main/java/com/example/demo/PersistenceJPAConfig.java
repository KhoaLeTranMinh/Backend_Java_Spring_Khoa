// package com.example.demo;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.orm.jpa.JpaTransactionManager;
// import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
// import org.springframework.transaction.PlatformTransactionManager;
// import
// org.springframework.transaction.annotation.EnableTransactionManagement;

// @Configuration
// @EnableTransactionManagement
// public class PersistenceJPAConfig {

// @Bean
// public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
// return null;
// // ...
// }

// @Bean
// public PlatformTransactionManager transactionManager() {
// JpaTransactionManager transactionManager = new JpaTransactionManager();
// transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
// return transactionManager;
// }
// }
