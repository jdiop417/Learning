package org.learning.spring.weather.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class WeatherResponse implements Serializable {
    private Weather data; // 消息数据
    private String status; // 消息状态
    private String desc; // 消息描述
}
