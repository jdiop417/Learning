package org.learning.spring.weather.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.mapper.Mapper;
import org.learning.spring.weather.service.WeatherDataService;
import org.learning.spring.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
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
        WeatherResponse weather = new WeatherResponse();
        ResponseEntity<String> resultStr = restTemplate.getForEntity(uri, String.class);
        if (resultStr.getStatusCodeValue() == HttpStatus.OK.value()) {
            String resultStrBody = resultStr.getBody();
            ObjectMapper mapper = new ObjectMapper();
            try {
                weather = mapper.readValue(resultStrBody, WeatherResponse.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return weather;
    }
}
