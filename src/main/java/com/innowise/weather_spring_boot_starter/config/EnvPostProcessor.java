package com.innowise.weather_spring_boot_starter.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@Slf4j
public class EnvPostProcessor implements EnvironmentPostProcessor {

    private static final String DEFAULT_CONFIG = "default.yaml";
    private static final String PROPERTY_SOURCE_NAME = "openweathermap-starter-default";

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        var resource = new ClassPathResource(DEFAULT_CONFIG);

        // Проверяем, существует ли файл
        if (!resource.exists()) {
            log.debug("Default config not found: {}", DEFAULT_CONFIG);
            return; // Молча пропускаем - нет конфига, нет проблем
        }

        try {
            new YamlPropertySourceLoader()
                    .load(PROPERTY_SOURCE_NAME, resource)
                    .forEach(propertySource -> {
                        environment.getPropertySources().addLast(propertySource);
                        log.debug("Loaded default configuration from {}", DEFAULT_CONFIG);
                    });

        } catch (IOException e) {
            // Логируем предупреждение вместо выбрасывания исключения
            log.error("Failed to load default config from {}: {}", DEFAULT_CONFIG, e.getMessage(), e);
        }
    }
}