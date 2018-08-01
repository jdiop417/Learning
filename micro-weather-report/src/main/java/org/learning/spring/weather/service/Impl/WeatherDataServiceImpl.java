package org.learning.spring.weather.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.learning.spring.weather.service.WeatherDataService;
import org.learning.spring.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class WeatherDataServiceImpl implements WeatherDataService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini";
    private final Long TIME_OUT = 1800L;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "?citykey=" + cityId;
        return doGetWeatherData(uri);
    }


    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "?city=" + cityName;
        return doGetWeatherData(uri);
    }


    private WeatherResponse doGetWeatherData(String uri) {
        WeatherResponse weather = new WeatherResponse();
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();

        //无缓冲，请求一波，写缓存
        String value = null;
        if (!stringRedisTemplate.hasKey(uri)) {
            log.info("未找到key:" + uri);
            ResponseEntity<String> resultStr = restTemplate.getForEntity(uri, String.class);
            if (resultStr.getStatusCodeValue() == HttpStatus.OK.value()) {
                value = resultStr.getBody();
                ops.set(uri, value, TIME_OUT, TimeUnit.SECONDS);
            }
        } else {//有缓存，取缓存
            log.info("找到key：" + uri);
            value = ops.get(uri);
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            weather = mapper.readValue(value, WeatherResponse.class);
        } catch (IOException e) {
            log.error(e.getMessage());
        }


        return weather;
    }

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
