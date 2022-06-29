package test;

import static org.junit.jupiter.api.Assertions.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.jupiter.api.Test;

import Contracts.IHttpService;
import Services.WeatherService;

class WeatherServiceTest 
{
	WeatherService weatherService;

	@Test
	void getCurrentWeatherCityNameTest() 
	{
		String cityName = "London";
    	String url = "http://api.openweathermap.org/data/2.5/weather?q="+cityName+"&APPID=71b541f19c963ba1bebdf79716bcb7c7";
		String result ="{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"base\":\"stations\",\"main\":{\"temp\":287.1,\"feels_like\":286.33,\"temp_min\":285.1,\"temp_max\":289.76,\"pressure\":1029,\"humidity\":68},\"visibility\":10000,\"wind\":{\"speed\":3.22,\"deg\":88,\"gust\":7.58},\"clouds\":{\"all\":0},\"dt\":1622319670,\"sys\":{\"type\":2,\"id\":2019646,\"country\":\"GB\",\"sunrise\":1622260298,\"sunset\":1622318674},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
		Mockery mockingContext;
		mockingContext = new Mockery();
		IHttpService mockedObject = mockingContext.mock(IHttpService.class);
		mockingContext.checking(new Expectations(){
		{
			oneOf(mockedObject).Http(url);
			will(returnValue(result));
		}
		});
		weatherService = new WeatherService(mockedObject);
		String x = weatherService.getCurrentWeather(cityName);
		assertEquals(result, x);
	}
	
	@Test
	void getCurrentWeatherCityNameTest1() 
	{
		String cityName = "";
    	weatherService = new WeatherService();
		String x = weatherService.getCurrentWeather(cityName);
		assertEquals(null, x);
	}
	
	@Test
	void getCurrentWeatherCityNameTest2() 
	{
		String cityName = null;
    	weatherService = new WeatherService();
		String x = weatherService.getCurrentWeather(cityName);
		assertEquals(null, x);
	}

}