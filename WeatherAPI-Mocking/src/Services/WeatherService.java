package Services;

import Contracts.IWeatherService;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class WeatherService implements IWeatherService {

    @Override
    public String getCurrentWeather(String cityName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getCurrentWeather(int cityId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getCurrentWeather(int latitude, int longitude) {
        // TODO Auto-generated method stub
        return null;
    }

}
