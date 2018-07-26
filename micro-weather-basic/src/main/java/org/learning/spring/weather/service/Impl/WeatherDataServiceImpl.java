package org.learning.spring.weather.service.Impl;

import lombok.Data;
import org.learning.spring.weather.service.WeatherDataService;
import org.learning.spring.weather.vo.WeatherResponse;

@Data
public class WeatherDataServiceImpl implements WeatherDataService {
    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        return null;
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        return null;
    }
}
