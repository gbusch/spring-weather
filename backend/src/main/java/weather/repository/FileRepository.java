package weather.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import weather.model.Price;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Repository
public class FileRepository {
    public static List<Price> getPrices() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new FileInputStream(new File("config/prices.json")), mapper.getTypeFactory().constructParametricType(List.class, Price.class));
    }
}
