package org.learning.spring.weather.service.Impl;

import org.learning.spring.weather.service.WeatherDataClient;
import org.learning.spring.weather.service.WeatherReportService;
import org.learning.spring.weather.vo.Weather;
import org.learning.spring.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatheReportServiceImpl implements WeatherReportService {
    @Autowired
    private WeatherDataClient weatherDataClient;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse resp = weatherDataClient.getDataByCityId(cityId);
        Weather data = resp.getData();
        return data;
    }

}
