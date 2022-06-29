package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.google.gson.JsonSyntaxException;

import Contracts.IJsonService;
import Services.GsonService;
import ViewModels.Respone;
import ViewModels.Weather;

class GsonServiceTest {

	@Test
	void fromJsonTest() 
	{
		IJsonService jsonService = new GsonService();
		String x = "{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"base\":\"stations\",\"main\":{\"temp\":287.1,\"feels_like\":286.33,\"temp_min\":285.1,\"temp_max\":289.76,\"pressure\":1029,\"humidity\":68},\"visibility\":10000,\"wind\":{\"speed\":3.22,\"deg\":88,\"gust\":7.58},\"clouds\":{\"all\":0},\"dt\":1622319670,\"sys\":{\"type\":2,\"id\":2019646,\"country\":\"GB\",\"sunrise\":1622260298,\"sunset\":1622318674},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
		Respone respone = jsonService.fromJson(x, Respone.class);
		Respone respone2 = new Respone();
		respone2.cod = 200;
		respone2.main = new Weather();
		respone2.main.temp = 287.1;
		assertEquals(respone2.cod, respone.cod);
		assertEquals(respone2.main.temp,respone.main.temp);
	}
	
	@Test
	void fromJsonTest2() 
	{
		IJsonService jsonService = new GsonService();
		Respone respone = jsonService.fromJson(" ", Respone.class);
		assertEquals(null,respone);
	}
	
	@Test
	void fromJsonTest3() 
	{
		IJsonService jsonService = new GsonService();
		Respone respone = jsonService.fromJson(null, Respone.class);
		assertEquals(null,respone);
	}
	
	@Test
	void fromJsonTest4() 
	{
		Throwable exception = assertThrows(JsonSyntaxException.class, () -> 
		{
			IJsonService jsonService = new GsonService();
			String x = "{\"Student\":{\"grade\":8,\"idds\":20186008}";
			Respone respone = jsonService.fromJson(x, Respone.class);
			Respone respone2 = new Respone();
			respone2.id = 9;
			assertEquals(respone2.id, respone.id);
		});
	}

	@Test
	void toJsonTest()
	{
		IJsonService jsonService = new GsonService();
		String x = "{\"main\":{\"temp\":287.1,\"feels_like\":286.33,\"temp_min\":285.1,\"temp_max\":289.76,\"pressure\":1029,\"humidity\":68},\"cod\":200,\"weather\":\"[{\\\"id\\\":800,\\\"main\\\":\\\"Clear\\\",\\\"description\\\":\\\"clear sky\\\",\\\"icon\\\":\\\"01n\\\"}]\",\"coord\":\"{\\\"lon\\\":-0.1257,\\\"lat\\\":51.5085}\",\"base\":\"stations\",\"visibility\":10000,\"wind\":\"{\\\"speed\\\":3.22,\\\"deg\\\":88,\\\"gust\\\":7.58}\",\"clouds\":\"{\\\"all\\\":0}\",\"dt\":1622319670,\"sys\":\"{\\\"type\\\":2,\\\"id\\\":2019646,\\\"country\\\":\\\"GB\\\",\\\"sunrise\\\":1622260298,\\\"sunset\\\":1622318674}\",\"timezone\":3600,\"id\":2643743,\"name\":\"London\"}";
		Respone respone = new Respone();
		respone.coord = "{\"lon\":-0.1257,\"lat\":51.5085}";
		respone.weather = "[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}]";
		respone.base = "stations";
		respone.main = new Weather();
		respone.main.temp = 287.1;
		respone.main.feels_like = 286.33;
		respone.main.temp_min = 285.1;
		respone.main.temp_max = 289.76;
		respone.main.pressure = 1029;
		respone.main.humidity = 68;
		respone.visibility = 10000;
		respone.wind = "{\"speed\":3.22,\"deg\":88,\"gust\":7.58}";
		respone.clouds = "{\"all\":0}";
		respone.dt = 1622319670;
		respone.sys = "{\"type\":2,\"id\":2019646,\"country\":\"GB\",\"sunrise\":1622260298,\"sunset\":1622318674}";
		respone.timezone = 3600;
		respone.id = 2643743;
		respone.name = "London";
		respone.cod = 200;
		String y = jsonService.toJson(respone);
		assertEquals(x,y);
	}
	
	@Test
	void toJsonTest2()
	{
		IJsonService jsonService = new GsonService();
		String y = jsonService.toJson(null);
		assertEquals("null",y);
	}
	
	@Test
	void toJsonTest3()
	{
		IJsonService jsonService = new GsonService();
		String y = jsonService.toJson("");
		assertEquals("\"\"",y);
	}

}