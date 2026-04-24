package com.innowise.weather_spring_boot_starter.config;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
@ConfigurationProperties(prefix = "openweathermap-starter")
public class OpenWeatherMapProperties {

    @NotBlank(message = "OpenWeatherMap API key is required")
    private String sdkKey;

    @NotBlank(message = "Default city is required")
    private String city;
}
