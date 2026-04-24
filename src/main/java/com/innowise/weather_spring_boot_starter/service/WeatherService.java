package com.innowise.weather_spring_boot_starter.service;

import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import com.github.prominence.openweathermap.api.enums.Language;
import com.github.prominence.openweathermap.api.enums.UnitSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeatherService {

    private static final Logger log = LoggerFactory.getLogger(WeatherService.class);
    private final String defaultCity;
    private final OpenWeatherMapClient client;

    public WeatherService(String defaultCity, OpenWeatherMapClient client) {
        this.defaultCity = defaultCity;
        this.client = client;
        log.info("WeatherService initialized for city: {}", defaultCity);
    }

    /**
     * Получить текстовое описание погоды для выбранного города.
     * @return строка с описанием текущей погоды, или сообщение об ошибке
     */
    public String getTemperature() {
        return getTemperatureForCity(defaultCity);
    }

    /**
     * Получить погоду для указанного города (преимущество - можно переиспользовать бин)
     */
    public String getTemperatureForCity(String cityName) {
        try {
            log.debug("Fetching weather for city: {}", cityName);

            var temperature = client.currentWeather()
                    .single()
                    .byCityName(cityName)
                    .unitSystem(UnitSystem.METRIC)
                    .language(Language.RUSSIAN)
                    .retrieve()
                    .asJava()
                    .getTemperature();

            String result = temperature.toString();
            log.info("Weather retrieved for {}: {}", cityName, result);
            return result;

        } catch (Exception e) {
            log.error("Failed to get weather for city: {}", cityName, e);
            return String.format("Не удалось получить погоду для города %s: %s",
                    cityName, e.getMessage());
        }
    }
}
