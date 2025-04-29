package dev.Java10x.CadastroDeNinjas.Missoes;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/missoes/ui")
public class MissoesControllerUI {

    private final MissoesService missoesService;

    public MissoesControllerUI(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public String mostrarTodosAsMissoes(Model model) {
        List<MissoesDTO> missao = missoesService.listarMissoes();
        model.addAttribute("missoes", missao);
        return "listarMissoes";
    }

    @GetMapping("/deletar/{id}")
    public String deletarMissoesPorId(@PathVariable Long id) {
        missoesService.deletarMissao(id);
        return "redirect:/missoes/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String listarMissoesPorId(@PathVariable Long id, Model model) {
        MissoesDTO missoes = missoesService.listarMissaoPorId(id);
        if (missoes != null) {
            model.addAttribute("missao", missoes);
            return "detalhesMissoes";
        } else {
            model.addAttribute("mensagen", "Missão não encontrado");
            return "listarMissoes";
        }
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarMissao(Model model) {
        model.addAttribute("missao", new MissoesDTO());
        return "adicionarMissoes";
    }

    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute MissoesDTO missoes, RedirectAttributes redirectAttributes) {
        missoesService.criarMissao(missoes);
        redirectAttributes.addFlashAttribute("mensagem", "Missão cadastrado com sucesso!");
        return "redirect:/missoes/ui/listar";

    }
}