weather-spring-boot-starter

---
# OpenWeatherMap Spring Boot Starter

[![Maven Central](https://img.shields.io/badge/Maven%20Central-0.0.1--SNAPSHOT-blue)](https://maven.apache.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.4-brightgreen)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-orange)](https://adoptium.net/)
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)

> Production-ready Spring Boot Starter for OpenWeatherMap API with auto-configuration, validation, and graceful error handling.

## 📋 Оглавление

- [Особенности](#-особенности)
- [Требования](#-требования)
- [Быстрый старт](#-быстрый-старт)
- [Конфигурация](#-конфигурация)
- [Использование](#-использование)
- [API Reference](#-api-reference)
- [Примеры](#-примеры)
- [Устранение проблем](#-устранение-проблем)
- [Внесение вклада](#-внесение-вклада)
- [Лицензия](#-лицензия)

## ✨ Особенности

| Функция | Описание |
|---------|----------|
| 🚀 **Zero Configuration** | Работает "из коробки" с `default.yaml` |
| 🔧 **Auto-Configuration** | Автоматическая настройка бинов Spring |
| ✅ **Валидация свойств** | Проверка обязательных параметров при старте |
| 🛡️ **Graceful Error Handling** | Обработка ошибок API без падения приложения |
| 📊 **Логирование** | Детальное логирование всех операций |
| 🎯 **Conditional Beans** | Бины создаются только при наличии настроек |
| 🔄 **Гибкость** | Легко переопределяется клиентским кодом |
| 🌍 **Метрики** | Поддержка нескольких единиц измерения и языков |

## 📦 Требования

- **Java**: 17 или выше
- **Spring Boot**: 3.2.x или выше
- **Maven**: 3.8+ / **Gradle**: 7.5+
- **OpenWeatherMap API Key**: [Получить бесплатно](https://openweathermap.org/api)

## 🚀 Быстрый старт

### 1. Добавьте зависимость

**Maven:**
```xml
<dependency>
    <groupId>com.innowise</groupId>
    <artifactId>openweathermap-starter</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>

---
