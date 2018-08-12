package org.learning.spring.weather.job;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.learning.spring.weather.service.CityClient;
import org.learning.spring.weather.service.WeatherDataCollectionService;
import org.learning.spring.weather.vo.City;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {
    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;
    @Autowired
    private CityClient cityClient;

    @Override
    protected void executeInternal(org.quartz.JobExecutionContext context) throws JobExecutionException {
        log.info("Weather Data Sync Job. Start！");
        //获取城市列表
        List<City> cityList = null;
        try {
            cityList = cityClient.listCity();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //遍历城市id获取天气
        for (City city : cityList) {
            log.info("Weather Data Sync Job, cityId:" + city.getCityId());
            weatherDataCollectionService.syncDataByCityId(city.getCityId());
        }
        log.info("Weather Data Sync Job. End！");
    }
}
