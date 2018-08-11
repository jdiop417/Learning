package org.learning.spring.weather.config;

import lombok.extern.slf4j.Slf4j;
import org.learning.spring.weather.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class QuartzConfiguration {

    private static final int TIME = 30 * 60;

    @Bean
    public JobDetail weatherDataSyncJobDetail() {
        JobDetail jobDetail = null;
        try {
            jobDetail = JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob").storeDurably().build();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return jobDetail;
    }

    @Bean
    public Trigger weatherDataSyncTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(TIME).repeatForever();
        return TriggerBuilder.newTrigger().forJob(this.weatherDataSyncJobDetail()).withIdentity("weatherDataSyncTrigger").withSchedule(scheduleBuilder).build();
    }
}
