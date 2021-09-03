package br.com.lollabe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lollabe.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
