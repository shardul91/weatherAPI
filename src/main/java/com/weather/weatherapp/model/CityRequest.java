package com.weather.weatherapp.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CityRequest {
    @NotBlank(message = "City name is required")
    @Size(min = 2, max = 100, message = "City name must be between 2-100 characters")
    private String cityName;
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}