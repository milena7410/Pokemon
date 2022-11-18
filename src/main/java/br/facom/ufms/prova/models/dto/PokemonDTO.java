package br.facom.ufms.prova.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class PokemonDTO {
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
}
