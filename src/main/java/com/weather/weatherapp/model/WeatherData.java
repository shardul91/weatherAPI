package com.weather.weatherapp.model;

public class WeatherData {
    private double temperature;
    private double humidity;
    private double windSpeed;
    private String units;
    private long timestamp;

    // Temperature with unit symbol
    public String getFormattedTemperature() {
        return String.format("%.1f°%s", temperature,
                "metric".equals(units) ? "C" : "F");
    }

    // Wind speed with appropriate unit
    public String getFormattedWindSpeed() {
        return String.format("%.1f %s", windSpeed,
                "metric".equals(units) ? "m/s" : "mph");
    }

    // Humidity remains percentage regardless of units
    public String getFormattedHumidity() {
        return humidity + "%";
    }

    // Getters and Setters
    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

    public double getHumidity() { return humidity; }
    public void setHumidity(double humidity) { this.humidity = humidity; }

    public double getWindSpeed() { return windSpeed; }
    public void setWindSpeed(double windSpeed) { this.windSpeed = windSpeed; }

    public String getUnits() { return units; }
    public void setUnits(String units) { this.units = units; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
}