package br.com.fiap.revisaoapi.dto;

import org.springframework.hateoas.RepresentationModel;

public class MaquiagemDTO extends RepresentationModel<MaquiagemDTO> {
    private Long id;
    private String nome;
    private String marca;
    private String categoria;
    private Double preco;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public String getCategoria(){
        return categoria;
    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    public Double getPreco(){
        return preco;
    }
    public void setPreco(Double preco){
        this.preco = preco;
    }
}
