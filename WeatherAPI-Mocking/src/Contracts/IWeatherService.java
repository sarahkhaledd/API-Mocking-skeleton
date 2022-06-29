package Contracts;

public interface IWeatherService {
    public String getCurrentWeather(String cityName);

    public String getCurrentWeather(int cityId);

    public String getCurrentWeather(int latitude, int longitude);
}
