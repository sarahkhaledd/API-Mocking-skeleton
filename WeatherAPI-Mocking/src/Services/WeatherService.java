package Services;

import Contracts.IHttpService;
import Contracts.IJsonService;
import Contracts.IWeatherService;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class WeatherService implements IWeatherService 
{
	String url;
	HttpService httpservice = new HttpService();
	String response;
    public IHttpService x;

    public WeatherService()
    {
    	x = new HttpService();
    }
    public WeatherService(IHttpService ihttpService) 
    {
        x = ihttpService;
    }
    @Override
    public String getCurrentWeather(String cityName) 
    {
    	if (cityName == null || cityName == "")
    		return null;   
    	url = "http://api.openweathermap.org/data/2.5/weather?q="+cityName+"&APPID=71b541f19c963ba1bebdf79716bcb7c7";
    	response = x.Http(url);
    	return response;
    }

    @Override
    public String getCurrentWeather(int cityId) 
    {
    	if (cityId <= 0) // early exits if any 
    		return null; 
    	 url = "http://api.openweathermap.org/data/2.5/weather?id="+cityId+"&appid=71b541f19c963ba1bebdf79716bcb7c7";
    	 response = httpservice.Http(url);
    	 return response;
    }

    @Override
    public String getCurrentWeather(int latitude, int longitude) 
    {
    	if (latitude == 0 && longitude == 0) // early exits if any 
    		return null;  
    	 url = "http://api.openweathermap.org/data/2.5/weather?lat="+latitude+"&lon="+longitude+"&APPID=71b541f19c963ba1bebdf79716bcb7c7";
    	 response = httpservice.Http(url);
    	 return response;
    }
}