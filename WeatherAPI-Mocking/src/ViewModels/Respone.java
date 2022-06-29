package ViewModels;

public class Respone 
{
	public Weather main;
	public int cod;
	public Object weather;
	public Object coord;
	public Object base;
	public int visibility;
	public Object wind;
	public Object clouds;
	public int dt;
	public Object sys;
	public int timezone;
	public int id;
	public Object name;
	
	public Respone()
	{
		main = new Weather();
	}
	//public Object message;
}
/*
 * {"coord":{"lon":-0.1257,"lat":51.5085},
 * "weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01n"}],
 * "base":"stations",
 * "main":{"temp":287.1,"feels_like":286.33,"temp_min":285.1,"temp_max":289.76,"pressure":1029,"humidity":68},
 * "visibility":10000,"wind":{"speed":3.22,"deg":88,"gust":7.58},
 * "clouds":{"all":0},"dt":1622319670,"sys":{"type":2,"id":2019646,"country":"GB","sunrise":1622260298,"sunset":1622318674},
 * "timezone":3600,
 * "id":2643743,
 * "name":"London",
 * "cod":200}
*/

//{"main":{"temp":287.1,"feels_like":286.33,"temp_min":285.1,"temp_max":289.76,"pressure":1029,"humidity":68}, "cod":200, "weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01n"}], "coord":{"lon":-0.1257,"lat":51.5085}} 