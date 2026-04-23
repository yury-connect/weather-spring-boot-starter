package com.innowise.weather_spring_boot_starter.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "openweathermap-starter")
public class OpenWeatherMapProperties {

    private String sdkKey;

    private String city;
}
