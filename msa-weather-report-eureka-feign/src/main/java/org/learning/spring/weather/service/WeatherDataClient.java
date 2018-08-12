package org.learning.spring.weather.service;

import org.learning.spring.weather.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient("msa-weather-data-eureka")
@Component
public interface WeatherDataClient {
    @GetMapping(value = "/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId")String cityId);
}
