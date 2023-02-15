package com.org.lojagames.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.*;

@Entity
@Table(name = "tb_produto")
@NoArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @NotBlank(message = "Esta informação é obrigatória")
    @Size(min = 5)
    @Getter @Setter
    private String descricao;

    @NotNull(message = "Esta informação é obrigatória")
    @Getter @Setter
    private double preco;

    @NotNull(message = "Esta informação é obrigatória")
    @Getter @Setter
    private int quantidade;

    @Size(max = 5000)
    @Getter @Setter
    private String foto;

    @ManyToOne
    @JsonIgnoreProperties("produto")
    @Getter @Setter
    private Categoria categoria;

    @ManyToOne
    @JsonIgnoreProperties("produto")
    @Getter @Setter
    private Usuario usuario;


    public Produto(Long id, String descricao, double preco, int quantidade, String foto) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.foto = foto;
    }
}
