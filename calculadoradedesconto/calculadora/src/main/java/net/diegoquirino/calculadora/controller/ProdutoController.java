package net.diegoquirino.calculadora.controller;

import net.diegoquirino.calculadora.model.Produto;
import net.diegoquirino.calculadora.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
@SessionScope
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("")
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("produtos/listar");
        modelAndView.addObject("produtos", this.produtoService.findAll());
        modelAndView.addObject("classActiveCalcularDesconto","active");
        return modelAndView;
    }

    @PostMapping("")
    public ModelAndView salvar(Produto produto) {
        ModelAndView modelAndView = new ModelAndView("produtos/listar");

        Long id = this.produtoService.createEdit(produto);

        modelAndView.addObject("type", "success");
        modelAndView.addObject("message", "Produto " + id + " salvo com sucesso!");
        modelAndView.addObject("classActiveCalcularDesconto","active");
        modelAndView.addObject("produtos", this.produtoService.findAll());
        return modelAndView;
    }

    @GetMapping("{id}")
    public ModelAndView editar(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("produtos/form");
        Produto produto = this.produtoService.findById(id).get();
        modelAndView.addObject("classActiveCalcularDesconto","active");
        modelAndView.addObject("produto", produto);
        return modelAndView;
    }

    @GetMapping("{id}/delete")
    public ModelAndView deletar(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("produtos/listar");
        Produto produto = this.produtoService.findById(id).get();
        this.produtoService.delete(produto);
        modelAndView.addObject("type", "danger");
        modelAndView.addObject("message", "Produto " + id + " excluído com sucesso!");
        modelAndView.addObject("classActiveCalcularDesconto","active");
        modelAndView.addObject("produtos", this.produtoService.findAll());
        return modelAndView;
    }

    @GetMapping("add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("produtos/form");
        Produto produto = new Produto();
        produto.setId(this.produtoService.getNextId());
        modelAndView.addObject("produto", produto);
        modelAndView.addObject("classActiveCalcularDesconto","active");
        return modelAndView;
    }

}
