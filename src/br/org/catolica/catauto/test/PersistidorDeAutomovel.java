package br.org.catolica.catauto.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.org.catolica.catauto.bean.Automovel;
import br.org.catolica.catauto.jpa.JPAUtil;

public class PersistidorDeAutomovel {

	public static void main(String[] args) {
		EntityManager em = 	JPAUtil.getEntityManager();
		Automovel auto = new Automovel();
		auto.setAnoFabricacao(2010);
		//auto.setModelo("Ferrari");
		auto.setObservacoes("Nunca foi batido");
		em.getTransaction().begin();
		em.persist(auto);
		em.getTransaction().commit();
		em.close();
		//emf.close();

	}
}
