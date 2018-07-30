package org.learning.spring.weather.service.Impl;

import org.learning.spring.weather.service.CityDataService;
import org.learning.spring.weather.util.XmlBuilder;
import org.learning.spring.weather.vo.City;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class CityDataServiceImpl implements CityDataService {
    @Override
    public List<City> listCity() throws Exception {
        //1.读取xml文件
        Resource resource = new ClassPathResource("citylist.xml");
        InputStreamReader inputStreamReader = new InputStreamReader(resource.getInputStream(), "utf-8");
        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuffer stringBuffer = new StringBuffer();
        String line = null;
        while ((line = reader.readLine()) != null) {
            stringBuffer.append(line);
        }
        //2.xml转化成java对象
        XmlBuilder.xmlStr2Object(City.class, stringBuffer.toString());
        return null;
    }
}
