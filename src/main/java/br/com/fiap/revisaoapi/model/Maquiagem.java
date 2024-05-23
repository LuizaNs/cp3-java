package br.com.fiap.revisaoapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_maquiagem")
public class Maquiagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Column(name = "nome")
    private String nome;

    @NotBlank(message = "A marca é obrigatória")
    @Column(name = "marca")
    private String marca;

    @NotBlank(message = "A categoria é obrigatória")
    @Column(name = "categoria")
    private String categoria;

    @NotBlank(message = "Deve ser informado se a marca é cruelty free ou não")
    @Column(name = "crueltyFree")
    private Boolean crueltyFree;

    @NotBlank(message = "O preço deve ser informado")
    @Column(name = "preco")
    private Double preco;

    public Maquiagem() {}

    public Maquiagem(Long id, String nome, String marca, String categoria, Boolean crueltyFree, Double preco) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.categoria = categoria;
        this.crueltyFree = crueltyFree;
        this.preco = preco;
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
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public Boolean getCrueltyFree() {
        return crueltyFree;
    }
    public void setCrueltyFree(Boolean crueltyFree) {
        this.crueltyFree = crueltyFree;
    }
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }

}
