package weather.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import weather.exception.NoWeatherInfoException;
import weather.exception.UnknownContractException;

import java.net.ConnectException;

@Service
public class WeatherService {
    @Value("${openweather.url}")
    private String apiUrl;

    @Value("${openweather.apikey}")
    private String apiKey;

    @Autowired
    private ContractService contractService;

    public String getWeather(String contractId, Double lat, Double lon) {
        contractService.getContractById(contractId)
                .orElseThrow(() -> new UnknownContractException("No contract"));
        final String uri = apiUrl + "?lat=" + lat + "&lon=" + lon + "&units=metric&appid=" + apiKey;
        try {
            JsonNode result = new RestTemplate().getForObject(uri, JsonNode.class);
            return "Weather in " + result.get("name").asText() + ": "
                    + result.get("weather").get(0).get("description").asText()
                    + " at " + result.get("main").get("temp").asText() + " degrees.";
        } catch (RestClientException e) {
            throw new NoWeatherInfoException("Weather information not available");
        }
    }
}
