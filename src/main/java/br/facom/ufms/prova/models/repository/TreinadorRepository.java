package br.facom.ufms.prova.models.repository;

import org.springframework.data.repository.CrudRepository;

import br.facom.ufms.prova.models.entity.Treinador;

public interface TreinadorRepository extends CrudRepository<Treinador, Integer>{
    
}
