package org.learning.spring.weather.service.Impl;

import lombok.Data;
import org.learning.spring.weather.service.WeatherDataService;
import org.learning.spring.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Data
public class WeatherDataServiceImpl implements WeatherDataService {
    @Autowired
    private RestTemplate restTemplate;
    private final String WEATHER_API = "http://wthrcdn.etouch.cn/weather_mini";

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_API + "?city=" + cityId;
        return doGetWeatherData(uri);
    }


    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_API + "?city=" + cityName;
        return doGetWeatherData(uri);
    }

    private WeatherResponse doGetWeatherData(String uri) {
        ResponseEntity<WeatherResponse> result = restTemplate.getForEntity(uri, WeatherResponse.class);
        if (result.getStatusCodeValue() == HttpStatus.OK.value()) {
            return result.getBody();
        }
        return null;
    }
}
