package weather.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import weather.service.ContractService;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({ContractController.class})
public class ContractControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContractService service;

    @Test
    void shouldGetOkWhenIsPrices() throws Exception {
        when(service.getPrices()).thenReturn(new ArrayList<>());
        mockMvc.perform(MockMvcRequestBuilders.get("/prices")).andExpect(status().isOk());
    }

    @Test
    void shouldReturn404WhenUnknownPathCalled() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/unknown/path")).andExpect(status().isNotFound());
    }
}
