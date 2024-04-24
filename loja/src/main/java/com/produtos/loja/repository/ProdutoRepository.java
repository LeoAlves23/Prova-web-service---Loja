package com.produtos.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.loja.doman.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
