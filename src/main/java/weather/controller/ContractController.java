package weather.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import weather.model.Contract;
import weather.repository.ContractRepository;

@RestController
public class ContractController {

    private final ContractRepository contractRepository;

    @Autowired
    public ContractController(final ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @PostMapping(path = "/contract")
    public @ResponseBody Contract purchaseContract(@RequestParam String name, @RequestParam double price) {
        Contract newContract = Contract
                .builder()
                .id(UUID.randomUUID().toString())
                .name(name)
                .price(price)
                .build();
        contractRepository.save(newContract);
        return newContract;
    }

    @GetMapping("/contracts")
    public @ResponseBody
    Iterable<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    @GetMapping("/contract/{id}")
    public @ResponseBody
    Optional<Contract> getContractById(@PathVariable String id) {
        return contractRepository.findById(id);
    }
}
