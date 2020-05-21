package weather.service;

import org.springframework.stereotype.Service;
import weather.model.Price;
import weather.repository.FileRepository;

import java.io.IOException;

@Service
public class FileService {
    public Iterable<Price> getPrices() throws IOException {
        return FileRepository.getPrices();
    }
}
