package dev.Java10x.CadastroDeNinjas.Ninjas.Controller.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

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
    @GetMapping("/porcurarID")
    public String procurarNinjaId() {
        return  "Ninja encontrado";
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas() ;
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/listarID")
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
