package asimo.v.services;

import asimo.v.entities.*;
import asimo.v.entities.operation.SessionOperation;
import asimo.v.repositories.ConfigurationRepository;
import asimo.v.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    private static String name = "protocol";

    SaleRepository saleRepository;

    ConfigurationRepository configurationRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public void createProtocol(Sale sale){

        if(saleRepository.findByProtocol(sale.getProtocol()).isPresent()){
            Optional<Configuration> configuration = configurationRepository.findByName(name);

            if(!configuration.isPresent()) {
                throw new RuntimeException("Configuração inválida");
            }

            Configuration config = configuration.get();
            sale.setProtocol(sale.generateProtocol(config.getValue()));
            saleRepository.save(sale);
            config.setValue(config.getValue() + 1);
            configurationRepository.save(config);
        }

    }
}
