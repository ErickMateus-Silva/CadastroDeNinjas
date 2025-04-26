package dev.Java10x.CadastroDeNinjas.Missoes;
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
    public  MissoesDTO criarMIssao(@RequestBody MissoesDTO missao) {
        return  missoesService.criarMissao(missao);
    }

    // Mostrar todos as Missoes (READ)
    @GetMapping("/listar")
    public List<MissoesDTO> mostrarTodosAsMissoes() {
        return  missoesService.listarMissoes();
    }

    // Mostar Missao por ID
    @GetMapping("/listar/{id}")
    public MissoesDTO listarPorId(@PathVariable Long id) {
        return missoesService.listarMissaoPorId(id);
    }

    // Alterar dados das Missoes (UPDATE)
    @PutMapping("/alterar/{id}")
    public  MissoesDTO AlterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada) {
        return  missoesService.altualizarMissao(id, missaoAtualizada);
    }

    // Deletar Missao (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorId(Long id) {
        missoesService.deletarMissao(id);
    }

}
