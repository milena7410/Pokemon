package br.facom.ufms.prova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.facom.ufms.prova.models.repository.PokemonRepository;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {
    
    @Autowired //injeta
    PokemonRepository pokemonRepository;
    // get
    @GetMapping
    public ResponseEntity<Object> getAllPokemons(){
        return ResponseEntity.status(HttpStatus.OK).body(pokemonRepository.findAll());
    }
    // post
    @PostMapping
    public ResponseEntity<Object> savePokemon(){
        return ResponseEntity.status(HttpStatus.OK).body("salvou pokemon");
    }
    // put
    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePokemon(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body("atualizou pokemon "+id);
    }
    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePokemon(){
        return ResponseEntity.status(HttpStatus.OK).body("deletou pokemon");
    }
    // recupera
    
    public ResponseEntity<Object> recuperaPokemon(){
        return null;
    }




}
