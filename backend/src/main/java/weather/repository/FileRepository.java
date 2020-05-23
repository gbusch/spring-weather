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
    public static List<Price> getPrices() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            FileInputStream stream = new FileInputStream(new File("config/prices.json"));
            return mapper.readValue(stream,
                    mapper.getTypeFactory().constructParametricType(List.class, Price.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Optional<Price> getPriceOfModel(String model) {
            List<Price> allPrices = getPrices();
            return allPrices.stream()
                    .filter(price -> price.getName().equals(model))
                    .findFirst();
    }
}
