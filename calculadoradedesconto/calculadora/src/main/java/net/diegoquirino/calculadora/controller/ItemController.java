package net.diegoquirino.calculadora.controller;

import net.diegoquirino.calculadora.model.Item;
import net.diegoquirino.calculadora.model.Produto;
import net.diegoquirino.calculadora.service.ItemService;
import net.diegoquirino.calculadora.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionScope
@RequestMapping("/itens")
public class ItemController {

    @Autowired
    ItemService itemService;

    @Autowired
    ProdutoService produtoService;

    /*@GetMapping("")
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("produtos/listar");
        modelAndView.addObject("produtos", this.produtoService.findAll());
        modelAndView.addObject("classActiveCalcularDesconto","active");
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
    }*/

    @PostMapping("produto/{id}")
    public ModelAndView salvar(@PathVariable Long id, Item item) {
        ModelAndView modelAndView = new ModelAndView("itens/calculo");

        item.setProduto(this.produtoService.findById(id).get());
        Long id_item = this.itemService.createEdit(item);

        modelAndView.addObject("type", "success");
        modelAndView.addObject("message", "Fator de desconto calculado com sucesso!");
        modelAndView.addObject("classActiveCalcularDesconto","active");
        modelAndView.addObject("item", this.itemService.findById(id_item).get());
        return modelAndView;
    }

    @GetMapping("add/produto/{id}")
    public ModelAndView add(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("itens/form");
        Item item = new Item();
        item.setId(this.itemService.getNextId());
        item.setProduto(this.produtoService.findById(id).get());
        modelAndView.addObject("item", item);
        modelAndView.addObject("produto", item.getProduto());
        modelAndView.addObject("classActiveCalcularDesconto","active");
        return modelAndView;
    }

}
