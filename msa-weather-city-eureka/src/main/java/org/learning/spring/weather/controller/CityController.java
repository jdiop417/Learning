package org.learning.spring.weather.controller;

import org.learning.spring.weather.service.CityDataService;
import org.learning.spring.weather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private CityDataService cityDataService;

    @GetMapping()
    public List<City> listCity() throws Exception {
        return cityDataService.listCity();
    }
}
