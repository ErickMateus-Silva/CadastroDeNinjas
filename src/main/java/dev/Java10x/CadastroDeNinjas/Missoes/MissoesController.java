package dev.Java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public class MissoesController {


    // Adicionar Missao (CREATE)
    @PostMapping("/criarM")
    public  String criarMIssao() {
        return  "Missao criarda";
    }
    // Procurar Missao por ID( CREATE)
    @GetMapping("/ProcurarM")
    public String procurarMissao() {
        return "Missao procurada";
    }

    // Mostrar todos as Missoes (READ)
    @GetMapping("/todosM")
    public  String mostrarTodosAsMissoes() {
        return  "Mostrar Missao";
    }

    // Mostrar Missao por ID (READ)
    @GetMapping("/todosMID")
    public  String mostrarTodosAsMissoesPorId() {
        return  "Mostrar Missao por id";
    }

    // Alterar dados das Missoes (UPDATE)
    @PutMapping("/alterarMID")
    public  String AlterarMissaoPorId() {
        return  "Alterar Missao por id";
    }

    // Deletar Missao (DELETE)
    @DeleteMapping("/deletarMID")
    public String deletarMissaoPorId() {
        return  "Missao deletado por id";
    }
}
