package com.colvir.colvirk8s.quartz;

import com.colvir.colvirk8s.service.SecurityCheckService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;

public class CreateSecurityCheckJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        try {
            ApplicationContext applicationContext = (ApplicationContext)
                    context.getScheduler().getContext().get("applicationContext");

            SecurityCheckService securityCheckService = applicationContext.getBean(SecurityCheckService.class);

            securityCheckService.create(LocalDateTime.now());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
