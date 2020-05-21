package weather.controller;

import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {
    @Value("${openweather.apikey}")
    private String apikey;

    @GetMapping("/weather")
    @ResponseBody public String getWeather(@RequestParam("lat") double lat, @RequestParam("lon") double lon) {
        final String uri = "https://api.openweathermap.org/data/2.5/weather?lat="
                + lat + "&lon=" + lon + "&units=metric&appid=" + apikey;
        JsonNode result = new RestTemplate().getForObject(uri, JsonNode.class);
        try {
            return "Weather in " + result.get("name").asText() + ": "
                    + result.get("weather").get(0).get("description").asText()
                    + " at " + result.get("main").get("temp").asText() + " degrees.";
        } catch (Exception e) {
            // TODO: catch different exceptions
            throw e;
        }
    }
}
