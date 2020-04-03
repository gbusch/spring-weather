package weather.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import weather.model.Contract;

@Transactional
public interface ContractRepository extends JpaRepository<Contract, String> {
    Optional<Contract> findById(String id);
}
