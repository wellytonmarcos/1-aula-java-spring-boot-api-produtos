package br.com.wellytonoliveira.produtosapi.controller;

import br.com.wellytonoliveira.produtosapi.model.Produto;
import br.com.wellytonoliveira.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }


    @PostMapping
    public Produto salvar(@RequestBody Produto produto)
    {
        System.out.println("Produto recebido: "+produto);
        var uuid = UUID.randomUUID().toString();
        produto.setId(uuid);
        produtoRepository.save(produto);
        return produto;
    }

}
