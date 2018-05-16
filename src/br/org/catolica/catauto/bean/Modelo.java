package br.org.catolica.catauto.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Modelo {

	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	@OneToMany(mappedBy = "modelo")
	private List<Automovel> automoveis;

	@ManyToOne
	private Marca marca;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Automovel> getAutomoveis() {
		return automoveis;
	}

	public void setAutomoveis(List<Automovel> automoveis) {
		this.automoveis = automoveis;
	}

}
