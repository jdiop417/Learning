package org.learning.spring.weather.service.Impl;

import org.learning.spring.weather.service.CityDataService;
import org.learning.spring.weather.util.XmlBuilder;
import org.learning.spring.weather.vo.City;
import org.learning.spring.weather.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityDataServiceImpl implements CityDataService {
    @Override
    public List<City> listCity() throws Exception {
        //1.读取xml文件
        Resource resource = new ClassPathResource("citylist.xml");
        //2.xml转化成java对象
        CityList cityList = (CityList) XmlBuilder.xmlStr2Object(CityList.class, resource.getInputStream());
        return cityList.getCityList();

    }
}
