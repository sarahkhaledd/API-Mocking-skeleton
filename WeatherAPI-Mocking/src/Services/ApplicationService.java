package Services;

import Contracts.IJsonService;
import Contracts.IWeatherService;
import ViewModels.Respone;

public class ApplicationService 
{
    private IWeatherService weatherService;
    private IJsonService jsonService;
   

    public ApplicationService(IWeatherService wService, IJsonService jService) 
    {
        weatherService = wService;
        jsonService = jService;
    }

    public String getCurrentWeather(String cityName) 
    {
    	if (cityName == null || cityName == "") // early exits if any 
    		return null;       
    	String jsonObject = weatherService.getCurrentWeather(cityName); // check response for errors and if so early exit
    	Respone respone = jsonService.fromJson(jsonObject, Respone.class); // parse response from weatherService using gsonService
    	if (respone.cod == 200)
    	{
        	String result = "The weather is " + respone.main.temp;
    		return result; // return appropriate response
    	}
    	else 
    		return "Invalid City Name";
    }
    public String getCurrentWeather(int cityId) 
    {
    	if (cityId <= 0) // early exits if any 
    		return null;       
    	String jsonObject = weatherService.getCurrentWeather(cityId); // check response for errors and if so early exit
    	Respone respone = jsonService.fromJson(jsonObject, Respone.class); // parse response from weatherService using gsonService
    	if (respone.cod == 200)
    	{
        	String result = "The weather is " +  respone.main.temp;
    		return result; // return appropriate response
    	}
    	else 
    		return "Invalid City ID";
    }
    public String getCurrentWeather(int latitude, int longitude) 
    {
    	if (latitude == 0 && longitude == 0) // early exits if any 
    		return null;       
    	String jsonObject = weatherService.getCurrentWeather(latitude,longitude); // check response for errors and if so early exit
    	Respone respone = jsonService.fromJson(jsonObject, Respone.class); // parse response from weatherService using gsonService
    	if (respone.cod == 200)
    	{
        	String result = "The weather is " +  respone.main.temp;
    		return result; // return appropriate response
    	}
    	else 
    		return "Invalid City Coordinates";
    }
}