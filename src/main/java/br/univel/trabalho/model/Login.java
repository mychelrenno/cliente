package br.univel.trabalho.model;

import java.io.Serializable;

public class Login implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String usuario;
	private String senha;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
