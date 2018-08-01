package org.learning.spring.weather.service.Impl;

import org.learning.spring.weather.service.WeatherDataService;
import org.learning.spring.weather.service.WeatherReportService;
import org.learning.spring.weather.vo.Weather;
import org.learning.spring.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatheReportServiceImpl implements WeatherReportService {
    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse weatherResponse = weatherDataService.getDataByCityId(cityId);
        return weatherResponse.getData();
    }

}
