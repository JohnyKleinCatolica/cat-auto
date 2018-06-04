package br.org.catolica.catauto.bean;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

@NamedQuery(name = Automovel.LISTAR_DESTAQUES, query = " select a from Automovel a", hints = {
		@QueryHint(name = "org.hibernate.cacheable", value = "true"),
		@QueryHint(name = "org.hibernate.cacheRegion", value = Automovel.LISTAR_DESTAQUES) })
@Entity
@Cacheable
@Audited
public class Automovel implements Bean{

	public static final String LISTAR_DESTAQUES = "Automovel.buscarDestaques";
	@Id
	@GeneratedValue
	private Long id;
	private Integer anoFabricacao;

	@ManyToOne
	@NotAudited
	private Modelo modelo;

	private Double preco;

	private String observacoes;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] fotografia;

	@ElementCollection
	@Column(length = 20)
	private List<String> tags;

	@ManyToMany
	@NotAudited
	private List<Opcional> opcionais;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public byte[] getFotografia() {
		return fotografia;
	}

	public void setFotografia(byte[] fotografia) {
		this.fotografia = fotografia;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public List<Opcional> getOpcionais() {
		return opcionais;
	}

	public void setOpcionais(List<Opcional> opcionais) {
		this.opcionais = opcionais;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
