package com.produtos.loja.doman;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome não pode ser nulo")
    @Size(min = 5, max = 55, message = "O nome precisa ter de 5 a 55 caractéres")
    private String nome;

    @Pattern(regexp = "UND|LT|KG|M", message = "Unidade inválida")
    private String und;

    private String localEstoque;

    @NotNull(message="O custo não pode ser nulo")
    @Min(value = 1, message = "O custo precisa ser maior do que 0")
    private Float custo;

    @NotNull(message = "O preço não pode ser nulo")
    private Float precoVenda;

    @ManyToOne
    @JoinColumn(name = "grupo_produto_id", nullable = false)
    private GrupoProduto grupoProduto;

    public Produto(Long id, @NotNull @Size(min = 5, max = 55) String nome, @Pattern(regexp = "UND|LT|KG|M") String und,
            String localEstoque, @NotNull @Min(1) Float custo, @NotNull Float precoVenda, GrupoProduto grupoProduto) {
        this.id = id;
        this.nome = nome;
        this.und = und;
        this.localEstoque = localEstoque;
        this.custo = custo;
        this.precoVenda = precoVenda;
        this.grupoProduto = grupoProduto;
    }

    

    public Produto() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnd() {
        return und;
    }

    public void setUnd(String und) {
        this.und = und;
    }

    public String getLocalEstoque() {
        return localEstoque;
    }

    public void setLocalEstoque(String localEstoque) {
        this.localEstoque = localEstoque;
    }

    public Float getCusto() {
        return custo;
    }

    public void setCusto(Float custo) {
        this.custo = custo;
    }

    public Float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public GrupoProduto getGrupoProduto() {
        return grupoProduto;
    }

    public void setGrupoProduto(GrupoProduto grupoProduto) {
        this.grupoProduto = grupoProduto;
    }

    
}
