package dev.Java10x.CadastroDeNinjas.Missoes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // Adicionar Missao (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarMIssao(@RequestBody MissoesDTO missao) {
         MissoesDTO novaMissao = missoesService.criarMissao(missao);
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body("Missao criado com sucesso: " + novaMissao.getNome() + " (ID) " + novaMissao.getId());
    }

    // Mostrar todos as Missoes (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> mostrarTodosAsMissoes() {
        List<MissoesDTO>  missoes = missoesService.listarMissoes();
        return  ResponseEntity.ok(missoes);
    }

    // Mostar Missao por ID
    @GetMapping("/listar/{id}")
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
