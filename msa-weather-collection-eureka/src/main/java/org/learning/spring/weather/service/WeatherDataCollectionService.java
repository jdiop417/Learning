package org.learning.spring.weather.service;

public interface WeatherDataCollectionService {

    void syncDataByCityId(String cityId);
}
