package br.facom.ufms.prova.models.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "pokebolas")
public class Pokebola {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nivel;
    
    @ManyToOne //muitas pokebolas para 1 treinador
    @JoinColumn(name = "treinadores_id")
    private Treinador treinador;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pokemon_id", referencedColumnName = "id")
    private Pokemon pokemons;
}
