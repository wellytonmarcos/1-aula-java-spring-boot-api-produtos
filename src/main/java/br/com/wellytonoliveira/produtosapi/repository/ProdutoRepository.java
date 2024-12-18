package br.com.wellytonoliveira.produtosapi.repository;

import br.com.wellytonoliveira.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
}
