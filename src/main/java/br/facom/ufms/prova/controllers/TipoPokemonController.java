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

import br.facom.ufms.prova.models.entity.TipoPokemon;
import br.facom.ufms.prova.models.repository.TipoPokemonRepository;

@RestController
@RequestMapping("/tipos_pokemons")

public class TipoPokemonController {
    @Autowired //injeta
    TipoPokemonRepository tipoPokemonRepository;
    // get
    @GetMapping
    public ResponseEntity<Object> getAllTipoPokemons(){
        return ResponseEntity.status(HttpStatus.OK).body(tipoPokemonRepository.findAll());
    }
    @PostMapping
    public ResponseEntity<Object> saveTipoPokemon(@RequestBody TipoPokemon tipoPokemonDTO){
        // salvando bd
        TipoPokemon tipoPokemonEntity = new TipoPokemon();
        BeanUtils.copyProperties(tipoPokemonDTO, tipoPokemonEntity);
        return ResponseEntity.status(HttpStatus.OK).body(tipoPokemonRepository.save(tipoPokemonEntity));
    }
    // put
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTipoPokemon(@PathVariable Integer id, @RequestBody TipoPokemon tipoPokemonDTO){
        Optional<TipoPokemon> tipoPokemonExists = tipoPokemonRepository.findById(id);
        if (!tipoPokemonExists.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("tipo de pokemon nao encontrada");
        }
        TipoPokemon tipoPokemonEntity = tipoPokemonExists.get();
        BeanUtils.copyProperties(tipoPokemonDTO, tipoPokemonEntity);
        return ResponseEntity.status(HttpStatus.OK).body(tipoPokemonRepository.save(tipoPokemonEntity));
    }
    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTipoPokemon(@PathVariable Integer id){
        Optional<TipoPokemon> tipoPokemonExists = tipoPokemonRepository.findById(id);
        if (!tipoPokemonExists.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("tipo nao encontado");
        }
        tipoPokemonRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("tipo deletado");
    }
}
