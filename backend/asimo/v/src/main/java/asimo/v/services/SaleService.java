package asimo.v.services;

import asimo.v.entities.Sale;
import asimo.v.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository vendaRepository;

    public ResponseEntity<Sale> findById(Long id){
        Optional<Sale> venda = vendaRepository.findById(id);

        if(venda.isPresent()){
            return ResponseEntity.ok().body(venda.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Sale> save(Sale venda){
        vendaRepository.save(venda);
        return ResponseEntity.ok().body(venda);
    }

    public ResponseEntity<Sale> update(Long id, Sale newVenda){
        Optional<Sale> oldVenda = vendaRepository.findById(id);

        if(oldVenda.isPresent()){
            newVenda.setId(oldVenda.get().getId());
            return save(newVenda);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Sale> delete(Long id){
        Optional<Sale> user = vendaRepository.findById(id);

        if(user.isPresent()){
            vendaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<List<Sale>> findAll(){
        List<Sale> vendas = vendaRepository.findAll();
        return ResponseEntity.ok().body(vendas);
    }

}
