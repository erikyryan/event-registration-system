package asimo.v.services;

import asimo.v.entities.Event;
import asimo.v.entities.Sale;
import asimo.v.entities.Session;
import asimo.v.entities.User;
import asimo.v.entities.operation.SessionOperation;
import asimo.v.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

//    public Sale createProtocol(Sale sale){


//        sale.setProtocol(sale.generateProtocol());
//    }
}
