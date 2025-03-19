package com.weather.weatherapp.model;
public class WeatherResponse {
    public Main main;
    public Wind wind;

    public static class Main {
        public double temp;
        public double humidity;
    }

    public static class Wind {
        public double speed;
    }
}

