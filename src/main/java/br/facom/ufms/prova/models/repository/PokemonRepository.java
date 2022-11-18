package br.facom.ufms.prova.models.repository;

import org.springframework.data.repository.CrudRepository;

import br.facom.ufms.prova.models.entity.Pokemon;

public interface PokemonRepository extends CrudRepository<Pokemon, Integer> {

    
}
