package asimo.v.repositories;

import asimo.v.entities.operation.SaleOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import asimo.v.entities.Sale;

import java.util.Optional;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Long> {
    Optional<Sale> findByProtocol(String protocol);

}
