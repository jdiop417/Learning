package org.learning.spring.weather.vo;

import java.io.Serializable;
import java.util.List;

public class Weather implements Serializable {
    private static final long serialVersionUID = -6236246827891710446L;
    private String city;
    private String aqi;
    private String ganmao;
    private String wendu;
    private Yesterday yesterday;
    private List<Forecast> forecast;
}
