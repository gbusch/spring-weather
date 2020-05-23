package weather.model;

import lombok.Data;

@Data
public class ContractRequest {
    private String name;
    private String model;
    private Double price;
}
