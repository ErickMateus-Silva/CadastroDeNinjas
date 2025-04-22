package dev.Java10x.CadastroDeNinjas.Ninjas.Controller.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é a minha primeira mensagem nessa rota";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public  String criarNinja() {
        return  "Ninja criardo";
    }
    // Procurar Ninja por ID( CREATE)
    @GetMapping("/procurarID")
    public String procurarNinjaId() {
        return  "Ninja procurado";
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/todos")
    public  String mostrarTodosOsNinja() {
        return  "Mostrar Ninja";
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/todosID")
    public  String mostrarTodosOsNinjaPorId() {
        return  "Mostrar Ninja por id";
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterarID")
    public  String AlterarNinjaPorId() {
        return  "Alterar Ninja por id";
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId() {
        return  "Ninja deletado por id";
    }
}
