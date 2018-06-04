package br.org.catolica.catauto.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import br.org.catolica.catauto.bean.Automovel;
import br.org.catolica.catauto.dao.AutomovelDao;
import br.org.catolica.catauto.jpa.JPAUtil;

@ManagedBean(name="automovelBeann")
public class AutomovelBean {

	private Automovel automovel = new Automovel();
	private AutomovelDao automovelDao =	new AutomovelDao();
//	private Marca marca;
	
	public void salva() {
		automovelDao.salva(automovel);
		this.automovel = new Automovel();
	}
	
	public List<Automovel> getAutomoveis(){
		return this.automovelDao.listaTodos();
	}
	
	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}
}
