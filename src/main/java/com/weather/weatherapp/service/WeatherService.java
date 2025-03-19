package com.weather.weatherapp.service;

import com.weather.weatherapp.config.OpenWeatherApiConfig;
import com.weather.weatherapp.exception.LocationNotFoundException;
import com.weather.weatherapp.exception.ServiceException;
import com.weather.weatherapp.model.GeoLocation;
import com.weather.weatherapp.model.OpenWeatherResponse;
import com.weather.weatherapp.model.WeatherData;
import com.weather.weatherapp.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class WeatherService {
    @Value("${openweather.api.key}")
    private String apiKey;

    @Value("${openweather.api.url}")
    private String apiBaseUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    // Simplified direct weather fetch (without geocoding)
    public WeatherData getCurrentWeather(String city) {
        String encodedCity = encodeCityName(city);
        String url = String.format("%sdata/2.5/weather?q=%s&appid=%s&units=metric",
                apiBaseUrl, encodedCity, apiKey);

        ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(url, WeatherResponse.class);
        return mapToWeatherData(response.getBody());
    }

    private String encodeCityName(String cityName) {
        try {
            return URLEncoder.encode(cityName, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Encoding error", e);
        }
    }

    private WeatherData mapToWeatherData(WeatherResponse response) {
        WeatherData data = new WeatherData();
        data.setTemperature(response.main.temp);
        data.setHumidity(response.main.humidity);
        data.setWindSpeed(response.wind.speed);
        return data;
    }
}