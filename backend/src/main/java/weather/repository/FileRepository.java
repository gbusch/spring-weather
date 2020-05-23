package weather.repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import weather.model.Price;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class FileRepository {
    public static List<Price> getPrices() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            FileInputStream stream = new FileInputStream(new File("config/prices.json"));
            return mapper.readValue(stream,
                    mapper.getTypeFactory().constructParametricType(List.class, Price.class));
        } catch (IOException e) {
            throw e;
        }
    }

    public static Optional<Price> getPriceOfModel(String model) throws IOException {
            List<Price> allPrices = getPrices();
            return allPrices.stream()
                    .filter(price -> price.getName().equals(model))
                    .findFirst();
    }
}
