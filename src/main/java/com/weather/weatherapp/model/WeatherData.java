package com.weather.weatherapp.model;

public class WeatherData {
    private double temperature;
    private double humidity;
    private double windSpeed;
    private String units;

    public String getFormattedTemperature() {
        return String.format("%.1f°%s", temperature,
                "metric".equals(units) ? "C" : "F");
    }

    public String getFormattedWindSpeed() {
        return String.format("%.1f %s", windSpeed,
                "metric".equals(units) ? "m/s" : "mph");
    }

    public String getFormattedHumidity() {
        return humidity + "%";
    }

    // Getters and setters
    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }
    public double getHumidity() { return humidity; }
    public void setHumidity(double humidity) { this.humidity = humidity; }
    public double getWindSpeed() { return windSpeed; }
    public void setWindSpeed(double windSpeed) { this.windSpeed = windSpeed; }
    public String getUnits() { return units; }
    public void setUnits(String units) { this.units = units; }
}