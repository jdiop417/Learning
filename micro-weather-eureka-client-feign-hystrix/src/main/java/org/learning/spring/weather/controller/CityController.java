package org.learning.spring.weather.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.learning.spring.weather.service.CityClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
    @Autowired
    private CityClient cityClient;

    @HystrixCommand(fallbackMethod = "defaultCities")
    @GetMapping("/cities")
    public String listCity() {
        String body = cityClient.listCity();
        return body;
    }

    public String defaultCities() {
        return "City Data Server is down!";
    }
}
