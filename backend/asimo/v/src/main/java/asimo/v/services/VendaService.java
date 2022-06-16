package asimo.v.services;

import asimo.v.entities.Venda;
import asimo.v.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public ResponseEntity<Venda> findById(Long id){
        Optional<Venda> venda = vendaRepository.findById(id);

        if(venda.isPresent()){
            return ResponseEntity.ok().body(venda.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Venda> save(Venda venda){
        Venda vendaSaved = vendaRepository.save(venda);
        return ResponseEntity.ok().body(venda);
    }

    public ResponseEntity<Venda> update(Long id, Venda newVenda){
        Optional<Venda> oldVenda = vendaRepository.findById(id);

        if(oldVenda.isPresent()){
            newVenda.setId(oldVenda.get().getId());
            return save(newVenda);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Venda> delete(Long id){
        Optional<Venda> user = vendaRepository.findById(id);

        if(user.isPresent()){
            vendaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<List<Venda>> findAll(){
        List<Venda> vendas = vendaRepository.findAll();
        return ResponseEntity.ok().body(vendas);
    }

}
