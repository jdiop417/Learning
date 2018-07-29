package org.learning.spring.weather.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name = "c")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class CityList {
    @XmlAttribute(name = "d")
    private List<City> cityList;
}
