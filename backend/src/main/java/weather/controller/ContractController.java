package weather.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import weather.model.Contract;
import weather.model.ContractRequest;
import weather.model.Price;
import weather.service.ContractService;

@RestController
public class ContractController {

    private final ContractService contractService;

    @Autowired
    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping("/prices")
    public @ResponseBody
    Iterable<Price> getAllPrices() throws IOException {return contractService.getPrices();
    }

    @PostMapping("/contract")
    public @ResponseBody Contract purchaseContract(@RequestBody ContractRequest request) throws IOException {
        return contractService.purchaseContract(request.getName(), request.getModel(), request.getPrice());
    }

    @GetMapping("/contracts")
    public @ResponseBody
    Iterable<Contract> getAllContracts() {
        return contractService.getAllContracts();
    }

    @GetMapping("/contract/{id}")
    public @ResponseBody
    Optional<Contract> getContractById(@PathVariable String id) {
        return contractService.getContractById(id);
    }
}
