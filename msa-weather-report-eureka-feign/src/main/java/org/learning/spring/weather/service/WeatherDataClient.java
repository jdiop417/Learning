package org.learning.spring.weather.service;

import org.learning.spring.weather.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@FeignClient
@Component
public interface WeatherDataClient {
    @RequestMapping(value = "/weather/cityId/{cityId}", method = RequestMethod.GET)
    WeatherResponse getDataByCityId(@PathVariable("cityId")String cityId);
}
