package org.learning.spring.weather.service;

import org.learning.spring.weather.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "msa-weather-city-eureka")
@Component
public interface CityClient {
    @RequestMapping(value = "/cities",method = RequestMethod.GET)
    List<City> listCity() throws Exception;
}
