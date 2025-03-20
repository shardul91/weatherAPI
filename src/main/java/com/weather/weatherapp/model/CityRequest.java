package com.weather.weatherapp.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CityRequest {
    @NotBlank(message = "City name is required")
    @Size(min = 2, max = 100, message = "City name must be 2-100 characters")
    private String cityName;

    // Getters and setters
    public String getCityName() { return cityName; }
    public void setCityName(String cityName) { this.cityName = cityName; }
}