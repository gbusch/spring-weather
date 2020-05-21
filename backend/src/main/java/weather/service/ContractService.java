package weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import weather.model.Contract;
import weather.model.Price;
import weather.repository.ContractRepository;
import weather.repository.FileRepository;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContractService {

    private final ContractRepository contractRepository;

    @Autowired
    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public Iterable<Price> getPrices() throws IOException {
        return FileRepository.getPrices();
    }

    public Contract purchaseContract(String name, double price) {
        Contract newContract = Contract
                .builder()
                .id(UUID.randomUUID().toString())
                .name(name)
                .price(price)
                .build();
        contractRepository.save(newContract);
        return newContract;
    }

    public Iterable<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    public Optional<Contract> getContractById(@PathVariable String id) {
        return contractRepository.findById(id);
    }
}
