
import Services.ApplicationService;
import Services.GsonService;
import Services.WeatherService;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        var application = new ApplicationService(new WeatherService(), new GsonService());
        System.out.println(application.getCurrentWeather("London")); 
        System.out.println(application.getCurrentWeather(-85,99));      
        System.out.println(application.getCurrentWeather(2643743));     
    }
}
