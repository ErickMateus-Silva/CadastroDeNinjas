package dev.Java10x.CadastroDeNinjas.Ninjas.Controller.Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Mensagem de boas vindas",description = "Essa rota da uma mensagem de boas vindas para quem acessa ela")
    public String boasVindas() {
        return "Essa é a minha primeira mensagem nessa rota";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Rota cria um novo ninja e inseri no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400",description = "Erro na criaçao do ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    @Operation(summary = "Lista os ninjas", description = "Rota listar os ninjas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "ninja nao encontrado")
    })
    public  ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas =  ninjaService.listarNinjas() ;
        return  ResponseEntity.ok(ninjas);
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista um ninja escolhido pelo id", description = "Rota listar um ninja por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso!"),
            @ApiResponse(responseCode = "404",description = "ninja nao encontrado")
    })
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
    @Operation(summary = "Altera um ninja", description = "Rota altera um  ninja pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso!"),
            @ApiResponse(responseCode = "404",description = "Ninja nao alterado")
    })
    public  ResponseEntity<?> AlterarNinjaPorId(
            @Parameter(description = "Usuario manda o id no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados do ninja a ser atualizado no corpo da requisição ")
            @RequestBody NinjaDTO ninjaAtualizado) {
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
    @Operation(summary = "Deleta um ninja escolhido pelo id", description = "Rota deletar um ninja por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso!"),
            @ApiResponse(responseCode = "404",description = "ninja nao encontrado")
    })
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
