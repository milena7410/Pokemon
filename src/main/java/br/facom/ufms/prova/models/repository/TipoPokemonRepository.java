package br.facom.ufms.prova.models.repository;

import org.springframework.data.repository.CrudRepository;

import br.facom.ufms.prova.models.entity.TipoPokemon;

public interface TipoPokemonRepository extends CrudRepository<TipoPokemon, Integer>{
    
}
