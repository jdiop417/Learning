package org.learning.spring.weather.service;

import org.learning.spring.weather.vo.City;

import java.util.List;

public interface CityDataService {
    List<City> listCity() throws Exception;
}
