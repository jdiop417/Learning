package org.learning.spring.weather.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("msa-weather-city-eureka")
@Component
public interface CityClient {
    @GetMapping("/cities")
    String listCity();
}
