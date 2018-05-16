package br.org.catolica.catauto.bean;

public class ResumoAutomovel {

	private String automovelMarca;
	private String automovelModelo;

	public ResumoAutomovel() {
		super();
	}

	public ResumoAutomovel(String automovelMarca, String automovelModelo) {
		super();
		this.automovelMarca = automovelMarca;
		this.automovelModelo = automovelModelo;
	}

	public String getAutomovelMarca() {
		return automovelMarca;
	}

	public void setAutomovelMarca(String automovelMarca) {
		this.automovelMarca = automovelMarca;
	}

	public String getAutomovelModelo() {
		return automovelModelo;
	}

	public void setAutomovelModelo(String automovelModelo) {
		this.automovelModelo = automovelModelo;
	}

}
