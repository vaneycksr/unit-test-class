package net.diegoquirino.calculadora.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import net.diegoquirino.calculadora.model.Contato;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SiteController {

    @GetMapping("/")
    public String paginaInicial(Model model) {
        model.addAttribute("classActiveIndex","active");
        return "index";
    }

    @GetMapping("/ajuda")
    public String paginaAjuda(Model model) {
        model.addAttribute("classActiveAjuda","active");
        return "ajuda";
    }

    @GetMapping("/contato")
    public String paginaContato(Model model) {
        model.addAttribute("classActiveContato","active");
        return "contato";
    }

    @PostMapping("/contato")
    public ModelAndView paginaEnviarContato(Contato contato) {
        ModelAndView modelAndView = new ModelAndView("contato");
        modelAndView.addObject("classActiveContato","active");
        modelAndView.addObject("type", "success");
        modelAndView.addObject("message", "Mensagem de " + contato.getTipo().toUpperCase() + " foi enviada com sucesso!");
        return modelAndView;
    }

}
