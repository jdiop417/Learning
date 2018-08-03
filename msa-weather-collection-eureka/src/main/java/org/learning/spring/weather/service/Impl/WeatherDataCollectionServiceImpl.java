package org.learning.spring.weather.service.Impl;

import org.learning.spring.weather.service.WeatherDataCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini";
    private final Long TIME_OUT = 1800L;

    @Override
    public void syncDataByCityId(String cityId) {
        String uri = WEATHER_URI + "?citykey=" + cityId;
        this.saveWeatherData(uri);
    }

    private void saveWeatherData(String uri) {
        ResponseEntity<String> forEntity = restTemplate.getForEntity(uri, String.class);
        if (forEntity.getStatusCodeValue() == HttpStatus.OK.value()) {
            String body = forEntity.getBody();
            ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
            ops.set(uri, body);
        }
    }
}
