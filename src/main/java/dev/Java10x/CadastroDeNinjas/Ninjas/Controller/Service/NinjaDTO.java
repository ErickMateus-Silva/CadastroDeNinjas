package dev.Java10x.CadastroDeNinjas.Ninjas.Controller.Service;

import dev.Java10x.CadastroDeNinjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private int idade;
    private MissoesModel missoes;
    private String rank;

}
