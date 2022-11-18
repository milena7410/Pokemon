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

import br.facom.ufms.prova.models.repository.TreinadorRepository;

@RestController
@RequestMapping("/treinadores")

public class TreinadorController {
    @Autowired //injeta
    TreinadorRepository treinadorRepository;
    // get
    @GetMapping
    public ResponseEntity<Object> getAllTreinadores(){
        return ResponseEntity.status(HttpStatus.OK).body(treinadorRepository.findAll());
    }
    // post
    @PostMapping
    public ResponseEntity<Object> saveTreinador(){
        return ResponseEntity.status(HttpStatus.OK).body("salvou pokemon");
    }
    // put
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTreinador(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body("atualizou pokemon "+id);
    }
    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTreinador(){
        return ResponseEntity.status(HttpStatus.OK).body("deletou pokemon");
    }
    
}
