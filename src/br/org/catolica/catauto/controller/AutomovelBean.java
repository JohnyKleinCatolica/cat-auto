package br.org.catolica.catauto.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import br.org.catolica.catauto.bean.AutomovelResumido;
import br.org.catolica.catauto.dao.AutomovelResumidoDao;
import br.org.catolica.catauto.jpa.JPAUtil;

@ManagedBean
public class AutomovelBean {

	private AutomovelResumido automovelResumido = 
				new AutomovelResumido();
	private AutomovelResumidoDao automovelResumidoDao =
				new AutomovelResumidoDao();

	public void salva() {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(automovelResumido);
		
		em.getTransaction().commit();
		em.close();
	}
	
	
	public List<AutomovelResumido> getAutomoveis(){
		return this.automovelResumidoDao.listaTodos();
	}
	
	public AutomovelResumido getAutomovelResumido() {
		return automovelResumido;
	}

	public void setAutomovelResumido(AutomovelResumido automovelResumido) {
		this.automovelResumido = automovelResumido;
	}


}
