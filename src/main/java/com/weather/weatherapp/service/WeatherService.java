package com.weather.weatherapp.service;

import com.weather.weatherapp.config.OpenWeatherApiConfig;
import com.weather.weatherapp.model.WeatherData;
import com.weather.weatherapp.model.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class WeatherService {

    private final OpenWeatherApiConfig apiConfig;
    private final RestTemplate restTemplate;

    @Autowired
    public WeatherService(OpenWeatherApiConfig apiConfig, RestTemplate restTemplate) {
        this.apiConfig = apiConfig;
        this.restTemplate = restTemplate;
    }

    @Cacheable(value = "weatherData", key = "{#city, #units}")
    public WeatherData getCurrentWeather(String city, String units) {
        try {
            String encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8.toString());
            String url = String.format("%sdata/2.5/weather?q=%s&units=%s&appid=%s",
                    apiConfig.getUrl(),
                    encodedCity,
                    units,
                    apiConfig.getKey());

            ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(url, WeatherResponse.class);
            return mapToWeatherData(response.getBody(), units);
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve weather data", e);
        }
    }

    private WeatherData mapToWeatherData(WeatherResponse response, String units) {
        WeatherData data = new WeatherData();
        data.setTemperature(response.getMain().getTemp());
        data.setHumidity(response.getMain().getHumidity());
        data.setWindSpeed(response.getWind().getSpeed());
        data.setUnits(units);
        return data;
    }
}