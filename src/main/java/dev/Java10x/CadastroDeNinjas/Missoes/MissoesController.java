package dev.Java10x.CadastroDeNinjas.Missoes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // Adicionar Missao (CREATE)
    @PostMapping("/criar")
    @Operation(summary = "Cria uma nova missao", description = "Rota cria uma nova missao e inseri no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missao criado com sucesso"),
            @ApiResponse(responseCode = "400",description = "Erro na criaçao da missao")
    })
    public ResponseEntity<String> criarMIssao(@RequestBody MissoesDTO missao) {
         MissoesDTO novaMissao = missoesService.criarMissao(missao);
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body("Missao criado com sucesso: " + novaMissao.getNome() + " (ID) " + novaMissao.getId());
    }

    // Mostrar todos as Missoes (READ)
    @GetMapping("/listar")
    @Operation(summary = "Lista todas as missoes", description = "Rota listar as missoes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missao encontrada com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Missao nao encontrada")
    })
    public ResponseEntity<List<MissoesDTO>> mostrarTodosAsMissoes() {
        List<MissoesDTO>  missoes = missoesService.listarMissoes();
        return  ResponseEntity.ok(missoes);
    }

    // Mostar Missao por ID
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista uma missao escolhida pelo id", description = "Rota listar uma missao por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missao encontrada com sucesso!"),
            @ApiResponse(responseCode = "404",description = "Missao nao encontrada")
    })
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        MissoesDTO missoes = missoesService.listarMissaoPorId(id);
        if (missoes != null) {
          return ResponseEntity.ok(missoes);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao: " + id + " nao encontrada nos nossos registros");
        }
    }

    // Alterar dados das Missoes (UPDATE)
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Alterar uma missao escolhido pelo id", description = "Rota alterar uma missao por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missao alterada com sucesso!"),
            @ApiResponse(responseCode = "404",description = "Missao nao encontrado")
    })
    public  ResponseEntity<?> AlterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada) {
       MissoesDTO missoes = missoesService.altualizarMissao(id, missaoAtualizada);
        if (missoes != null) {
            return ResponseEntity.ok(missoes);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao: "+ id + " nao encontrado");
        }
    }

    // Deletar Missao (DELETE)
    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta uma missao escolhido pelo id", description = "Rota deletar uma missao por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missao deletada com sucesso!"),
            @ApiResponse(responseCode = "404",description = "Missao nao encontrado")
    })
    public ResponseEntity<String> deletarMissaoPorId(@PathVariable Long id) {
        if (missoesService.listarMissaoPorId(id) != null ) {
            missoesService.deletarMissao(id);
            return ResponseEntity.ok("Missoa: "+ id + " deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao: "+ id + " nao encontrado nos registros");
        }
    }

}
