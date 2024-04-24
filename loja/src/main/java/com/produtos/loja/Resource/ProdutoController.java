package com.produtos.loja.Resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.loja.Service.ProdutoService;
import com.produtos.loja.doman.Produto;

import jakarta.validation.Valid;




@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/")
    public ResponseEntity<Produto> postProduto(@Valid @RequestBody final Produto produto) {
        produtoService.save(produto);
        return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<List<Produto>> getAll() {
        List<Produto> produtos = produtoService.findAll();
        return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable("id") Long id) {
        Produto produto = produtoService.findById(id);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> putId(@PathVariable("id") Long id, @RequestBody Produto produto) {
        Produto produto2 = produtoService.findById(id);
        produto2.setNome(produto.getNome());
        produto2.setUnd(produto.getUnd());
        produto2.setLocalEstoque(produto.getLocalEstoque());
        produto2.setCusto(produto.getCusto());
        produto2.setPrecoVenda(produto.getPrecoVenda());
        produtoService.update(produto2);
        return new ResponseEntity<Produto>(produto2, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        produtoService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
