package org.learning.spring.weather.service;

import org.learning.spring.weather.vo.City;
import org.learning.spring.weather.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "msa-weather-eureka-client-zuul")
@Component
public interface DataClient {
    @GetMapping("/city/cities")
    List<City> listCity();

    @GetMapping(value = "/data/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);

}
