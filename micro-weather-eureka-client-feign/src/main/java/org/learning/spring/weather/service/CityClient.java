package org.learning.spring.weather.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("sa-weather-city-eureka")
public interface CityClient {
    @GetMapping("/cities")
    String listCity();
}
