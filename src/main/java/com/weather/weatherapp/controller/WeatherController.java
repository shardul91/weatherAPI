package com.weather.weatherapp.controller;

import com.weather.weatherapp.model.CityRequest;
import com.weather.weatherapp.model.WeatherData;
import com.weather.weatherapp.service.WeatherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("request", new CityRequest());
        return "weather";
    }

    @PostMapping
    public String getWeather(
            @Valid @ModelAttribute("request") CityRequest request,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "weather";
        }

        try {
            WeatherData data = weatherService.getCurrentWeather(request.getCityName());
            model.addAttribute("weather", data);
            model.addAttribute("city", request.getCityName());
        } catch (Exception e) {
            model.addAttribute("error", "Error retrieving data: " + e.getMessage());
        }

        return "weather";
    }
}