package dev.Java10x.CadastroDeNinjas.Ninjas.Controller.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é a minha primeira mensagem nessa rota";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public  ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas =  ninjaService.listarNinjas() ;
        return  ResponseEntity.ok(ninjas);
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public  ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listaNinjasPorId(id);
        if (ninja != null) {
            return  ResponseEntity.ok(ninja);
        } else  {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id: " + id + " nao nos nossos registros");
        }
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public  ResponseEntity<?> AlterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
       NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninja != null) {
           return ResponseEntity.ok(ninja);
       } else {
           return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body("O ninja com id " + id + " nao encontrado");
       }
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
       if (ninjaService.listaNinjasPorId(id) != null){
           ninjaService.deletarNinjaPorId(id);
           return ResponseEntity.ok("Ninja com o ID " + id + " deletado com sucesso!");
       } else {
           return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body("O ninja com id " + id + " nao encontrado");
       }
    }
}
