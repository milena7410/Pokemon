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

import br.facom.ufms.prova.models.dto.FraquezaDTO;
import br.facom.ufms.prova.models.entity.Fraqueza;
import br.facom.ufms.prova.models.repository.FraquezaRepository;

@RestController
@RequestMapping("/fraquezas")

public class FraquezaController {
    @Autowired //injeta
    FraquezaRepository fraquezaRepository;
    // get
    @GetMapping
    public ResponseEntity<Object> getAllFraquezas(){
        return ResponseEntity.status(HttpStatus.OK).body(fraquezaRepository.findAll());
    }
    // post
    @PostMapping
    public ResponseEntity<Object> saveFraqueza(@RequestBody FraquezaDTO fraquezaDTO){
        // salvando bd
        Fraqueza fraquezaEntity = new Fraqueza();
        BeanUtils.copyProperties(fraquezaDTO, fraquezaEntity);
        return ResponseEntity.status(HttpStatus.OK).body(fraquezaRepository.save(fraquezaEntity));
    }
    // put
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateFraqueza(@PathVariable Integer id, @RequestBody FraquezaDTO fraquezaDTO){
        Optional<Fraqueza> fraquezaExists = fraquezaRepository.findById(id);
        if (!fraquezaExists.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("fraqueza nao encontrada");
        }
        Fraqueza fraquezaEntity = fraquezaExists.get();
        BeanUtils.copyProperties(fraquezaDTO, fraquezaEntity);
        return ResponseEntity.status(HttpStatus.OK).body(fraquezaRepository.save(fraquezaEntity));
    }
    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFraqueza(@PathVariable Integer id){
        Optional<Fraqueza> fraquezaExists = fraquezaRepository.findById(id);
        if (!fraquezaExists.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("fraqueza nao encontada");
        }
        fraquezaRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("fraqueza deletada");
    }
    
    
}
