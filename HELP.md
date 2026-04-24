Видосик, по которому писал: https://www.youtube.com/watch?v=PtaWjv_aTbQ&t=22s

## 📁 Структура проекта

```text
weather-spring-boot-starter/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/innowise/weather_spring_boot_starter/
│       │       ├── config/
│       │       │   ├── EnvPostProcessor.java
│       │       │   ├── OpenWeatherMapAutoConfiguration.java
│       │       │   └── OpenWeatherMapProperties.java
│       │       ├── service/
│       │       │   └── WeatherService.java
│       │       └── WeatherSpringBootStarterApplication.java
│       └── resources/
│           ├── META-INF/
│           │   ├── spring/
│           │   │   └── org.springframework.boot.autoconfigure.AutoConfiguration.imports
│           │   └── spring.factories
│           ├── default.yaml  ← ВАЖНО! Правильное расположение
│           └── application.properties
└── pom.xml
```

