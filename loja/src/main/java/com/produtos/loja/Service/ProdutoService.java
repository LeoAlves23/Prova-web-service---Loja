package com.produtos.loja.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtos.loja.doman.Produto;
import com.produtos.loja.repository.ProdutoRepository;

import jakarta.validation.Valid;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public void save(@Valid Produto produto) {
        produtoRepository.save(produto);
    }

    public void update(Produto produto) {
        if (produtoRepository.existsById(produto.getId())) {
            produtoRepository.save(produto);
        }
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }
}
