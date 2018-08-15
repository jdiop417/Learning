package org.learning.spring.weather.service;

import com.google.common.collect.Lists;
import org.learning.spring.weather.vo.City;
import org.learning.spring.weather.vo.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataClientFallback implements DataClient {

    @Override
    public List<City> listCity() {
        List<City> cityList = null;
        cityList = Lists.newArrayList();

        City city = new City();
        city.setCityId("101280601");
        city.setCityName("深圳");
        cityList.add(city);

        city = new City();
        city.setCityId("101280301");
        city.setCityName("惠州");
        cityList.add(city);
        return cityList;
    }


    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        return null;
    }
}
