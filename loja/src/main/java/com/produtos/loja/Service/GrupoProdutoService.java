package com.produtos.loja.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtos.loja.doman.GrupoProduto;
import com.produtos.loja.repository.GrupoProdutoRepository;

@Service
public class GrupoProdutoService {

    @Autowired
    private GrupoProdutoRepository grupoProdutoRepository;

    public List<GrupoProduto> findAll() {
        return grupoProdutoRepository.findAll();
    }

    public GrupoProduto findById(Long id) {
        return grupoProdutoRepository.findById(id).orElse(null);
    }

    public void save(GrupoProduto grupoProduto) {
        grupoProdutoRepository.save(grupoProduto);
    }

    public void update(GrupoProduto grupoProduto) {
        if (grupoProdutoRepository.existsById(grupoProduto.getId())) {
            grupoProdutoRepository.save(grupoProduto);
        }
    }

    public void deleteById(Long id) {
        grupoProdutoRepository.deleteById(id);
    }

}
