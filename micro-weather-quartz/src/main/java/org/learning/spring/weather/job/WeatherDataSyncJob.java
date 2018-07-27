package org.learning.spring.weather.job;

import lombok.extern.slf4j.Slf4j;
import org.learning.spring.weather.service.WeatherDataService;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {
    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    protected void executeInternal(org.quartz.JobExecutionContext context) throws JobExecutionException {
        log.info("拉数据");
    }
}
