package br.com.docket.docketRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CartorioController {

    @Autowired
    private CartorioRepository repository;


    ////Criar Cartorio
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/cartorio")
    public Cartorio save(@RequestBody Cartorio cartorio) {
        System.out.println("Nome: " + (cartorio));
        return repository.save(cartorio);
    }

    ////Editar Cartorio
    @PutMapping("/cartorio/{id}")
    public Cartorio update(@PathVariable Long id, @RequestBody Cartorio cartorio) {

        return repository.findById(id).map(x -> {
            x.setNome(cartorio.getNome());
            return repository.save(x);
        }).orElseGet(() -> {
            cartorio.setId(id);
            return repository.save(cartorio);
        });
    }

    ////Visualizar Cartório
    @GetMapping("/cartorio/id/{id}")
    public Optional<Cartorio> findById(@PathVariable Long id) {
        return repository.findById(id);
    }

    ////Excluir Cartório
    @DeleteMapping("/cartorio/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    ////Listar Cartórios
    @GetMapping("/cartorio/lista")
    public List<Cartorio> findAll() {
        return repository.findAll();
    }
}




