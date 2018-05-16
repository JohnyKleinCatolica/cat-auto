package br.org.catolica.catauto.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.org.catolica.catauto.bean.Automovel;
import br.org.catolica.catauto.bean.ResumoAutomovel;
import br.org.catolica.catauto.jpa.JPAUtil;

public class JpqlTest {

	private static EntityManager em;

	@BeforeClass
	public static void begin() {
		em = JPAUtil.getEntityManager();
	}

	@AfterClass
	public static void end() {
		em.close();
	}

	@Test
	public void listaAutomovelTest() {
		String jpql = " select a from Automovel a " + "	where a.modelo.marca.nome = :nomeMarca ";
		Query query = em.createQuery(jpql, Automovel.class);
		query.setParameter("nomeMarca", "Ferrari");
		List<Automovel> automoveis = query.getResultList();
		Assert.assertNotNull(automoveis.size());
	}

	@Test
	public void listaDetalheAutomovelTest() {
		String jpql = " select new " + 
				"	br.org.catolica.catauto.bean.ResumoAutomovel("
				+ "	a.modelo.marca.nome, a.modelo.nome) " 
				+ "	from Automovel a ";
		Query query = em.createQuery(jpql);
		List<ResumoAutomovel> automoveis = query.getResultList();
		for (ResumoAutomovel resumoAutomovel : automoveis) {
			Assert.assertNotNull(resumoAutomovel.getAutomovelMarca());
			Assert.assertNotNull(resumoAutomovel.getAutomovelModelo());
		}
		Assert.assertNotNull(automoveis.size());

	}
	
	@Test
	public void listaAutomovelNamedQueryTest() {
		Query query = em.createNamedQuery("Automovel.listarTodos", Automovel.class);
		List<Automovel> automoveis = query.getResultList();
		for (Automovel automovel : automoveis) {
			Assert.assertNotNull(automovel.getId());
			Assert.assertNotNull(automovel.getModelo());
		}
		Assert.assertNotNull(automoveis.size());

	}

}
