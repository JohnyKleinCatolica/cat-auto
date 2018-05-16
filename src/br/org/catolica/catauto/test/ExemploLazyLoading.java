package br.org.catolica.catauto.test;

import javax.persistence.EntityManager;

import br.org.catolica.catauto.bean.Marca;
import br.org.catolica.catauto.jpa.JPAUtil;

public class ExemploLazyLoading {
	
	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		Marca marca = em.find(Marca.class, 1L);
		marca.getModelos().size();
	}

}
