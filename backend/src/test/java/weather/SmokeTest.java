package weather;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import weather.controller.ContractController;
import weather.controller.WeatherController;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private ContractController contractController;

    @Autowired
    private WeatherController weatherController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(contractController).isNotNull();
        assertThat(weatherController).isNotNull();
    }
}
