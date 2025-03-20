package com.weather.weatherapp.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherResponse {
    private Main main;
    private Wind wind;

    public static class Main {
        @JsonProperty("temp")
        private double temp;
        @JsonProperty("humidity")
        private double humidity;

        public double getTemp() { return temp; }
        public double getHumidity() { return humidity; }
    }

    public static class Wind {
        @JsonProperty("speed")
        private double speed;

        public double getSpeed() { return speed; }
    }

    public Main getMain() { return main; }
    public Wind getWind() { return wind; }
}