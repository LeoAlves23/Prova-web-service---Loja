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

import com.produtos.loja.Service.GrupoProdutoService;
import com.produtos.loja.doman.GrupoProduto;




@RestController
@RequestMapping("/grupo")
public class GrupoProdutoController {

    @Autowired
    private GrupoProdutoService grupoService;

    @GetMapping("/")
    public ResponseEntity<List<GrupoProduto>> getAll() {
        List<GrupoProduto> grupoProdutos = grupoService.findAll();
        return new ResponseEntity<List<GrupoProduto>>(grupoProdutos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupoProduto> getById(@PathVariable("id") Long id) {
        GrupoProduto grupoProduto = grupoService.findById(id);
        return new ResponseEntity<GrupoProduto>(grupoProduto, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<GrupoProduto> post(@RequestBody final GrupoProduto grupoProduto) {
        grupoService.save(grupoProduto);
        return new ResponseEntity<GrupoProduto>(grupoProduto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GrupoProduto> putGrupo (@PathVariable("id") Long id, @RequestBody GrupoProduto grupoProduto) {
        GrupoProduto grupoProduto2 = grupoService.findById(id);
        grupoProduto2.setDescricao(grupoProduto.getDescricao());
        grupoService.update(grupoProduto2);
        return new ResponseEntity<GrupoProduto>(grupoProduto2, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        grupoService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
