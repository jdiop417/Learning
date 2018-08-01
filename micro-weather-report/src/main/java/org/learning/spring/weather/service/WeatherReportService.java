package org.learning.spring.weather.service;

import org.learning.spring.weather.vo.Weather;

public interface WeatherReportService {
    Weather getDataByCityId(String cityId);
}
