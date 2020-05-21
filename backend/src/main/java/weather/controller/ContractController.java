package weather.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import weather.model.Contract;
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
    public @ResponseBody Contract purchaseContract(@RequestParam String name, @RequestParam double price) {
        return contractService.purchaseContract(name, price);
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
