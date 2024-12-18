package br.com.wellytonoliveira.produtosapi.controller;

import br.com.wellytonoliveira.produtosapi.model.Produto;
import br.com.wellytonoliveira.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable("id") String id) {
       return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable("id") String id)
    {
        produtoRepository.deleteById(id);
    }

    @GetMapping
    public List<Produto> buscar(@RequestParam("nome") String nome){

        return produtoRepository.findByNome(nome);
    }


    @PutMapping("{id}")
    public Produto atualizar(@PathVariable("id") String id, @RequestBody Produto produto)
    {
        produto.setId(id);
        produtoRepository.save(produto);
        return produto ;

    }




}
