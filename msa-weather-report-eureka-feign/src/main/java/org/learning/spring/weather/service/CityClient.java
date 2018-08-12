package org.learning.spring.weather.service;

import org.learning.spring.weather.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
@FeignClient(value = "msa-weather-city-eureka")
public interface CityClient {

    @GetMapping("/cities")
    List<City> listCity();


}
