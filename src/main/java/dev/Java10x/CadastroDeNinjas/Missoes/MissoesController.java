package dev.Java10x.CadastroDeNinjas.Missoes;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {


    // Adicionar Missao (CREATE)
    @PostMapping("/criar")
    public  String criarMIssao() {
        return  "Missao criarda";
    }
    // Procurar Missao por ID( CREATE)
    @GetMapping("/ProcurarID")
    public String procurarMissao() {
        return "Missao procurada";
    }

    // Mostrar todos as Missoes (READ)
    @GetMapping("/listar")
    public  String mostrarTodosAsMissoes() {
        return  "Mostrar Missao";
    }

    // Alterar dados das Missoes (UPDATE)
    @PutMapping("/alterarID")
    public  String AlterarMissaoPorId() {
        return  "Alterar Missao por id";
    }

    // Deletar Missao (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarMissaoPorId() {
        return  "Missao deletado por id";
    }
}
