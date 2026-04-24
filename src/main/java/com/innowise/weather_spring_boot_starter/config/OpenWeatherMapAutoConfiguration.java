package com.innowise.weather_spring_boot_starter.config;

import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import com.innowise.weather_spring_boot_starter.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableConfigurationProperties(OpenWeatherMapProperties.class)
@ConditionalOnProperty(prefix = "openweathermap-starter", name = "sdk-key") // Не создаём бин если нет ключа
public class OpenWeatherMapAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public WeatherService weatherService(OpenWeatherMapProperties properties) {
        log.info("Configuring WeatherService with city: {}", properties.getCity());

        // Добавляем проверку на null на всякий случай
        if (properties.getSdkKey() == null || properties.getSdkKey().isBlank()) {
            throw new IllegalStateException("OpenWeatherMap SDK key must be configured");
        }

        var client = new OpenWeatherMapClient(properties.getSdkKey());
        return new WeatherService(properties.getCity(), client);
    }
}
