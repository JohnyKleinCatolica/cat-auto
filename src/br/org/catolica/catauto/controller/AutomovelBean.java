package br.org.catolica.catauto.controller;

import javax.faces.bean.ManagedBean;

import br.org.catolica.catauto.bean.AutomovelResumido;
import br.org.catolica.catauto.dao.AutomovelResumidoDao;

@ManagedBean
public class AutomovelBean {

	private AutomovelResumido automovelResumido = 
				new AutomovelResumido();
	private AutomovelResumidoDao automovelResumidoDao =
				new AutomovelResumidoDao();

	public void salva() {
		automovelResumidoDao.salva(automovelResumido);
		this.automovelResumido = new AutomovelResumido();
	}
	
	
	public AutomovelResumido getAutomovelResumido() {
		return automovelResumido;
	}

	public void setAutomovelResumido(AutomovelResumido automovelResumido) {
		this.automovelResumido = automovelResumido;
	}


}
