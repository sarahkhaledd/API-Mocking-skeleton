package test;

import static org.junit.jupiter.api.Assertions.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.jupiter.api.Test;

import Contracts.IJsonService;
import Contracts.IWeatherService;
import Services.ApplicationService;
import Services.GsonService;
import Services.WeatherService;
import ViewModels.Respone;
import ViewModels.Weather;

class ApplicationServiceTest 
{
	ApplicationService applicationService;
	WeatherService weatherService;
	Respone respone;
	Weather weather;
	IJsonService jService = new GsonService();
	String result ="{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"base\":\"stations\",\"main\":{\"temp\":287.1,\"feels_like\":286.33,\"temp_min\":285.1,\"temp_max\":289.76,\"pressure\":1029,\"humidity\":68},\"visibility\":10000,\"wind\":{\"speed\":3.22,\"deg\":88,\"gust\":7.58},\"clouds\":{\"all\":0},\"dt\":1622319670,\"sys\":{\"type\":2,\"id\":2019646,\"country\":\"GB\",\"sunrise\":1622260298,\"sunset\":1622318674},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
	@Test
	void getCurrentWeatherCityNameTest1() 
	{
		String cityName = "london";
		respone = new Respone();
		respone.cod = 200;
		respone.main = new Weather();
		respone.main.temp = 287.1;
		Mockery mockingContext;
		Mockery mockingContext2;
		mockingContext = new Mockery();
		mockingContext2 = new Mockery();
		IWeatherService mockedObject = mockingContext.mock(IWeatherService.class);
		IJsonService mockedObject2 = mockingContext2.mock(IJsonService.class);
		mockingContext.checking(new Expectations(){
		{
			oneOf(mockedObject).getCurrentWeather(cityName);
			will(returnValue(result));
		}
		});
		mockingContext2.checking(new Expectations(){
			{
				oneOf(mockedObject2).fromJson(result, Respone.class);
				will(returnValue(respone));
			}
			});
		applicationService = new ApplicationService(mockedObject, mockedObject2);
		String x = applicationService.getCurrentWeather(cityName);
		mockingContext.assertIsSatisfied();
		assertEquals("The weather is 287.1", x);
		
	}
	
	@Test
	void getCurrentWeatherCityNameTest2() 
	{
		String cityName = "ppp";
		respone = new Respone();
		respone.cod = 404;
		respone.main = new Weather();
		respone.main.temp = 287.1;
		Mockery mockingContext;
		Mockery mockingContext2;
		mockingContext = new Mockery();
		mockingContext2 = new Mockery();
		IWeatherService mockedObject = mockingContext.mock(IWeatherService.class);
		IJsonService mockedObject2 = mockingContext2.mock(IJsonService.class);
		mockingContext.checking(new Expectations(){
		{
			oneOf(mockedObject).getCurrentWeather(cityName);
			will(returnValue(result));
		}
		});
		mockingContext2.checking(new Expectations(){
		{
			oneOf(mockedObject2).fromJson(result, Respone.class);
			will(returnValue(respone));
		}
		});
		applicationService = new ApplicationService(mockedObject, mockedObject2);
		String x = applicationService.getCurrentWeather(cityName);
		mockingContext.assertIsSatisfied();
		assertEquals("Invalid City Name", x);
		
	}
	
	@Test
	void getCurrentWeatherCityNameTest3() 
	{
		String cityName = null;
		applicationService = new ApplicationService(weatherService,jService);
		String x = applicationService.getCurrentWeather(cityName);
		assertEquals(null, x);	
	}
	
	@Test
	void getCurrentWeatherCityNameTest4() 
	{
		String cityName = "";
		applicationService = new ApplicationService(weatherService,jService);
		String x = applicationService.getCurrentWeather(cityName);
		assertEquals(null, x);	
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	void getCurrentWeatherIDTest() 
	{
		int cityId = 2643743;
		respone = new Respone();
		respone.cod = 200;
		respone.main = new Weather();
		respone.main.temp = 287.1;
		Mockery mockingContext;
		Mockery mockingContext2;
		mockingContext = new Mockery();
		mockingContext2 = new Mockery();
		IWeatherService mockedObject = mockingContext.mock(IWeatherService.class);
		IJsonService mockedObject2 = mockingContext2.mock(IJsonService.class);
		mockingContext.checking(new Expectations(){
		{
			oneOf(mockedObject).getCurrentWeather(cityId);
			will(returnValue(result));
		}
		});
		mockingContext2.checking(new Expectations(){
		{
			oneOf(mockedObject2).fromJson(result, Respone.class);
			will(returnValue(respone));
		}
		});
		applicationService = new ApplicationService(mockedObject, mockedObject2);
		String x = applicationService.getCurrentWeather(cityId);
		mockingContext.assertIsSatisfied();
		assertEquals("The weather is 287.1", x);
		
	}
	
	@Test
	void getCurrentWeatherIDTest2() 
	{
		int cityId = 1;
		respone = new Respone();
		respone.cod = 404;
		respone.main = new Weather();
		respone.main.temp = 287.1;
		Mockery mockingContext;
		Mockery mockingContext2;
		mockingContext = new Mockery();
		mockingContext2 = new Mockery();
		IWeatherService mockedObject = mockingContext.mock(IWeatherService.class);
		IJsonService mockedObject2 = mockingContext2.mock(IJsonService.class);
		mockingContext.checking(new Expectations(){
		{
			oneOf(mockedObject).getCurrentWeather(cityId);
			will(returnValue(result));
		}
		});
		mockingContext2.checking(new Expectations(){
		{
			oneOf(mockedObject2).fromJson(result, Respone.class);
			will(returnValue(respone));
		}
		});
		applicationService = new ApplicationService(mockedObject, mockedObject2);
		String x = applicationService.getCurrentWeather(cityId);
		mockingContext.assertIsSatisfied();
		assertEquals("Invalid City ID", x);
		
	}
	@Test
	void getCurrentWeatherIDTest3() 
	{
		int cityId = 0;
		applicationService = new ApplicationService(weatherService,jService);
		String x = applicationService.getCurrentWeather(cityId);
		assertEquals(null, x);	
	}
	
	@Test
	void getCurrentWeatherIDTest4() 
	{
		int cityId = -1;
		applicationService = new ApplicationService(weatherService,jService);
		String x = applicationService.getCurrentWeather(cityId);
		assertEquals(null, x);	
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	void getCurrentWeatherLonTest2() 
	{
		int latitude = -29;
		int longitude = 58; 
		respone = new Respone();
		respone.cod = 200;
		respone.main = new Weather();
		respone.main.temp = 287.1;
		Mockery mockingContext;
		Mockery mockingContext2;
		mockingContext = new Mockery();
		mockingContext2 = new Mockery();
		IWeatherService mockedObject = mockingContext.mock(IWeatherService.class);
		IJsonService mockedObject2 = mockingContext2.mock(IJsonService.class);
		mockingContext.checking(new Expectations(){
		{
			oneOf(mockedObject).getCurrentWeather(latitude,longitude);
			will(returnValue(result));
		}
		});
		mockingContext2.checking(new Expectations(){
		{
			oneOf(mockedObject2).fromJson(result, Respone.class);
			will(returnValue(respone));
		}
		});
		applicationService = new ApplicationService(mockedObject, mockedObject2);
		String x = applicationService.getCurrentWeather(latitude,longitude);
		mockingContext.assertIsSatisfied();
		assertEquals("The weather is 287.1", x);
		
	}
	
	@Test
	void getCurrentWeatherLonTest3() 
	{
		int latitude = 29;
		int longitude = -58; 
		respone = new Respone();
		respone.cod = 200;
		respone.main = new Weather();
		respone.main.temp = 287.1;
		Mockery mockingContext;
		Mockery mockingContext2;
		mockingContext = new Mockery();
		mockingContext2 = new Mockery();
		IWeatherService mockedObject = mockingContext.mock(IWeatherService.class);
		IJsonService mockedObject2 = mockingContext2.mock(IJsonService.class);
		mockingContext.checking(new Expectations(){
		{
			oneOf(mockedObject).getCurrentWeather(latitude,longitude);
			will(returnValue(result));
		}
		});
		mockingContext2.checking(new Expectations(){
		{
			oneOf(mockedObject2).fromJson(result, Respone.class);
			will(returnValue(respone));
		}
		});
		applicationService = new ApplicationService(mockedObject, mockedObject2);
		String x = applicationService.getCurrentWeather(latitude,longitude);
		mockingContext.assertIsSatisfied();
		assertEquals("The weather is 287.1", x);
		
	}	
	
	@Test
	void getCurrentWeatherLonTest4() 
	{
		int latitude = -29;
		int longitude = -58; 
		respone = new Respone();
		respone.cod = 200;
		respone.main = new Weather();
		respone.main.temp = 287.1;
		Mockery mockingContext;
		Mockery mockingContext2;
		mockingContext = new Mockery();
		mockingContext2 = new Mockery();
		IWeatherService mockedObject = mockingContext.mock(IWeatherService.class);
		IJsonService mockedObject2 = mockingContext2.mock(IJsonService.class);
		mockingContext.checking(new Expectations(){
		{
			oneOf(mockedObject).getCurrentWeather(latitude,longitude);
			will(returnValue(result));
		}
		});
		mockingContext2.checking(new Expectations(){
		{
			oneOf(mockedObject2).fromJson(result, Respone.class);
			will(returnValue(respone));
		}
		});
		applicationService = new ApplicationService(mockedObject, mockedObject2);
		String x = applicationService.getCurrentWeather(latitude,longitude);
		mockingContext.assertIsSatisfied();
		assertEquals("The weather is 287.1", x);
		
	}
	
	@Test
	void getCurrentWeatherLonTest5() 
	{
		int latitude = Integer.MIN_VALUE;
		int longitude = Integer.MAX_VALUE; 
		respone = new Respone();
		respone.cod = 200;
		respone.main = new Weather();
		respone.main.temp = 287.1;
		Mockery mockingContext;
		Mockery mockingContext2;
		mockingContext = new Mockery();
		mockingContext2 = new Mockery();
		IWeatherService mockedObject = mockingContext.mock(IWeatherService.class);
		IJsonService mockedObject2 = mockingContext2.mock(IJsonService.class);
		mockingContext.checking(new Expectations(){
		{
			oneOf(mockedObject).getCurrentWeather(latitude,longitude);
			will(returnValue(result));
		}
		});
		mockingContext2.checking(new Expectations(){
		{
			oneOf(mockedObject2).fromJson(result, Respone.class);
			will(returnValue(respone));
		}
		});
		applicationService = new ApplicationService(mockedObject, mockedObject2);
		String x = applicationService.getCurrentWeather(latitude,longitude);
		mockingContext.assertIsSatisfied();
		assertEquals("The weather is 287.1", x);
		
	}
	
	@Test
	void getCurrentWeatherLonTest6() 
	{
		int latitude = 0;
		int longitude = 0; 
		applicationService = new ApplicationService(weatherService,jService);
		String x = applicationService.getCurrentWeather(latitude,longitude);
		assertEquals(null, x);
		
	}
}
