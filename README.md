# Weather Application

A web application that retrieves and displays current weather information using the OpenWeather API, with features for unit conversion and performance caching.

## Features

- Current weather data for any city worldwide
- Temperature unit conversion (Celsius/Fahrenheit)
- Humidity and wind speed display
- Responsive web design
- API response caching for better performance
- Error handling and input validation

## Technologies Used

- **Backend**: 
  - Java 17
  - Spring Boot 3.x
  - Spring Web MVC
  - Spring Cache
  - Caffeine Cache

- **Frontend**:
  - Thymeleaf
  - Bootstrap 5
  - HTML5/CSS3

- **Tools**:
  - Maven
  - OpenWeather API

## Prerequisites

- Java 17 or higher
- Maven 3.6.3 or higher
- OpenWeather API key (Free tier)

## Getting Started

### 1. Obtain API Key

1. Go to [OpenWeatherMap](https://openweathermap.org/)
2. Create a free account
3. Navigate to [API Keys](https://home.openweathermap.org/api_keys)
4. Generate a new key (may take 10-20 minutes to activate)

### 2. Configure Application

1. Clone the repository:
   ```bash
   git clone https://github.com/shardul91/weatherAPI.git

   cd weatherAPI

   Create configuration file: echo "openweather.api.key=YOUR_API_KEY" > src/main/resources/application.properties

   Build the project: mvn clean install

   Run the application: mvn spring-boot:run

   Access the application at: http://localhost:8080/weather

Usage

    Enter a city name in the search box (e.g., "London,uk")

    Click "Search"

    Toggle between Celsius/Fahrenheit using the unit buttons

    View current weather information including:

        Temperature

        Humidity

        Wind Speed   

Future Enhancements

    5-day weather forecast

    Air quality index display

    Localization support        
