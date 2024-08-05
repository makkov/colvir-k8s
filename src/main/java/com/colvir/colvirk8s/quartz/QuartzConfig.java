package com.colvir.colvirk8s.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail createJobDetail() {
        return JobBuilder.newJob().ofType(CreateSecurityCheckJob.class)
                .storeDurably()
                .withIdentity("createJob")
                .build();
    }

    @Bean
    public Trigger createJobTrigger() {
        return TriggerBuilder.newTrigger()
                .forJob(createJobDetail())
                .withIdentity("createJobTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/3 * * * * ?"))
                .build();
    }

    @Bean
    public JobDetail doCheckJobDetail() {
        return JobBuilder.newJob(DoSecurityCheckJob.class)
                .withIdentity("doCheckJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger doCheckJobTrigger() {
        return TriggerBuilder.newTrigger()
                .forJob(doCheckJobDetail())
                .withIdentity("doCheckJobTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/6 * * * * ?"))
                .build();
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
        schedulerFactory.setJobDetails(createJobDetail(), doCheckJobDetail());
        schedulerFactory.setTriggers(createJobTrigger(), doCheckJobTrigger());
        schedulerFactory.setApplicationContextSchedulerContextKey("applicationContext");
        return schedulerFactory;
    }
}
