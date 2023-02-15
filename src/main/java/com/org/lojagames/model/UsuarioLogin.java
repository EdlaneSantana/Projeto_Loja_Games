package com.org.lojagames.model;

import lombok.Data;

@Data
public class UsuarioLogin {

    private Long id;
    private String nome;
    private String usuario;
    private String senha;
    private String foto;
    private int tipoUsuario;
    private String token;
}
