package Services;

import Contracts.IJsonService;
import Contracts.IWeatherService;

public class ApplicationService {
    private IWeatherService weatherService;
    private IJsonService jsonService;

    public ApplicationService(IWeatherService wService, IJsonService jService) {
        weatherService = wService;
        jsonService = jService;
    }

    public String getCurrentWeather(String cityName) {
        // early exits if any
        // invoke weatherService method with cityName
        // check response for errors and if so early exit
        // parse response from weatherService using jsonService
        // return appropriate response
        return null;
    }
}
