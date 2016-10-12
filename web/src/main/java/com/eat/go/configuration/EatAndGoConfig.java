package com.eat.go.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Properties;

@Configuration
public class EatAndGoConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Value("${spring.datasource.url}")
    private String dataBaseUrl;

    @Value("${spring.datasource.username}")
    private String dataBaseLogin;

    @Value("${spring.datasource.password}")
    private String dataBasePassword;

    @Bean
    public TransactionTemplate txTemplate(PlatformTransactionManager manager){
        TransactionTemplate txTemplate = new TransactionTemplate();
        txTemplate.setTransactionManager(manager);
        return txTemplate;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean quartzScheduler  = new SchedulerFactoryBean();
        quartzScheduler.setApplicationContext(applicationContext);
        quartzScheduler.setConfigLocation(new ClassPathResource("schedule.properties"));

        Properties p = new Properties();
        p.setProperty("org.quartz.dataSource.quartzDS.URL", dataBaseUrl);
        p.setProperty("org.quartz.dataSource.quartzDS.user", dataBaseLogin);
        p.setProperty("org.quartz.dataSource.quartzDS.password", dataBasePassword);
        quartzScheduler.setQuartzProperties(p);

        CreateTaskFactory jobFactory = new CreateTaskFactory();
        jobFactory.setApplicationContext(applicationContext);
        quartzScheduler.setJobFactory(jobFactory);
        return quartzScheduler ;
    }
}
