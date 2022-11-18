package br.facom.ufms.prova.models.entity;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tipos")
public class TipoPokemon {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;

    @JsonBackReference //nao entrar em loop
    @ManyToMany
    @JoinTable (name = "pokemons_tipo", 
    joinColumns = @JoinColumn(name = "tipos_id"),
    inverseJoinColumns = @JoinColumn(name = "pokemons_id"))
    private List<Pokemon> pokemons;
}
