package br.org.catolica.catauto.bean;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Cacheable
public class Marca {

	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	@OneToOne(cascade = CascadeType.ALL)
	private DetalheMarca detalhe;

	@OneToMany(mappedBy = "marca",
			// fetch=FetchType.EAGER,
			cascade = CascadeType.ALL)
	private List<Modelo> modelos;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public DetalheMarca getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(DetalheMarca detalhe) {
		this.detalhe = detalhe;
	}

	public List<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
