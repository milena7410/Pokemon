package br.facom.ufms.prova.controllers;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.facom.ufms.prova.models.dto.HabilidadeDTO;
import br.facom.ufms.prova.models.entity.Habilidade;
import br.facom.ufms.prova.models.repository.HabilidadeRepository;

@RestController
@RequestMapping("/habilidades")
public class HabilidadeController {
    @Autowired //injeta
    HabilidadeRepository habilidadeRepository;
    // get
    @GetMapping
    public ResponseEntity<Object> getAllHabilidades(){
        return ResponseEntity.status(HttpStatus.OK).body(habilidadeRepository.findAll());
    }
    // post
    @PostMapping
    public ResponseEntity<Object> saveHabilidade(@RequestBody HabilidadeDTO habilidadeDTO){
        // salvando bd
        Habilidade habilidadeEntity = new Habilidade();
        BeanUtils.copyProperties(habilidadeDTO, habilidadeEntity);
        return ResponseEntity.status(HttpStatus.OK).body(habilidadeRepository.save(habilidadeEntity));
    }
    // put
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateHabilidade(@PathVariable Integer id, @RequestBody HabilidadeDTO habilidadeDTO){
        Optional<Habilidade> habilidadeExists = habilidadeRepository.findById(id);
        if (!habilidadeExists.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("habilidade nao encontrada");
        }
        Habilidade habilidadeEntity = habilidadeExists.get();
        BeanUtils.copyProperties(habilidadeDTO, habilidadeEntity);
        return ResponseEntity.status(HttpStatus.OK).body(habilidadeRepository.save(habilidadeEntity));
    }
    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteHabilidade(@PathVariable Integer id){
        Optional<Habilidade> habilidadeExists = habilidadeRepository.findById(id);
        if (!habilidadeExists.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("habilidade nao encontada");
        }
        habilidadeRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("habilidade deletada");
    }
    
}
