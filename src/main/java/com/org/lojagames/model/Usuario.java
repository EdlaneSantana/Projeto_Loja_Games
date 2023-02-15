package com.org.lojagames.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Entity
@Table(name = "tb_usuario")
@NoArgsConstructor
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 4)
    private String nome;

    @NotBlank
    @Size(min = 4)
    private String usuario;

    @NotBlank
    @Size(min = 4)
    private String senha;

    @NotBlank
    @Size(max = 5000)
    private String foto;

    @NotNull
    @Max(1)
    private int tipoUsuario;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnoreProperties("usuario")
    private List<Produto> produto;

    public Usuario(Long id, String nome, String usuario, String senha, String foto, int tipoUsuario) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.foto = foto;
        this.tipoUsuario = tipoUsuario;
    }


}
