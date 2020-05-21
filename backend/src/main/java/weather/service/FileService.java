package weather.service;

import weather.model.Price;
import weather.repository.FileRepository;

import java.io.IOException;

public class FileService {
    public Iterable<Price> getPrices() throws IOException {
        return FileRepository.getPrices();
    }
}
