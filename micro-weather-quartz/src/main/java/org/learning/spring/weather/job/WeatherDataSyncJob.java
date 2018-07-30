package org.learning.spring.weather.job;

import lombok.extern.slf4j.Slf4j;
import org.learning.spring.weather.service.CityDataService;
import org.learning.spring.weather.service.WeatherDataService;
import org.learning.spring.weather.vo.City;
import org.learning.spring.weather.vo.CityList;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {
    @Autowired
    private WeatherDataService weatherDataService;
    @Autowired
    private CityDataService cityDataService;

    @Override
    protected void executeInternal(org.quartz.JobExecutionContext context) throws JobExecutionException {
        log.info("Weather Data Sync Job. Start！");
        //获取城市列表
        List<City> cityList = null;
        try {
            cityList = cityDataService.listCity();
        } catch (Exception e) {
            log.error("Exception!" + e.getMessage());
        }
        //遍历城市id获取天气
        for (City city : cityList) {
            log.info("Weather Data Sync Job, cityId:" + city.getCityId());
            weatherDataService.syncDataByCityId(city.getCityId());
        }
        log.info("Weather Data Sync Job. End！");
    }
}
