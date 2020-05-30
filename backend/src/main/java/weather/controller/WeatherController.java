package weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import weather.service.WeatherService;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }


    @GetMapping("/weather/{contractId}")
    @ResponseBody public String getWeather(@PathVariable String contractId, @RequestParam("lat") Double lat, @RequestParam("lon") Double lon) {
        return weatherService.getWeather(contractId, lat, lon);
    }
}
