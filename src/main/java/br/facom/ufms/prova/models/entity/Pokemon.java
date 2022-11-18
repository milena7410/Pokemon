package br.facom.ufms.prova.models.entity;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "pokemons")
public class Pokemon {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private Float altura;
    private Float peso;
    private Integer hp;
    private Integer ataque;
    private Integer defesa;
    private Integer spAtaque;
    private Integer spDefesa;
    private Float velocidade;

    // fraquezas
    @JsonManagedReference //nao entrar em loop
    @ManyToMany(mappedBy = "pokemons", fetch = FetchType.LAZY)
    private List<Fraqueza> fraquezas;

    // habilidades
    @ManyToMany(mappedBy = "pokemons", fetch = FetchType.LAZY)
    private List<Habilidade> habilidades;

    // tipos
    @ManyToMany(mappedBy = "pokemons", fetch = FetchType.LAZY)
    private List<TipoPokemon> tipos;

     // pokebola
     @OneToOne(mappedBy = "pokemons")
     private Pokebola pokebolas;
     
}
