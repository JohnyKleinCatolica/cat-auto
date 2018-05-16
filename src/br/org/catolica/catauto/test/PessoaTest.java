package br.org.catolica.catauto.test;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import br.org.catolica.catauto.bean.PessoaFisica;
import br.org.catolica.catauto.bean.PessoaJuridica;
import br.org.catolica.catauto.jpa.JPAUtil;

public class PessoaTest {

	@Test
	public void salvaTest(){
		EntityManager em = JPAUtil.getEntityManager();
		PessoaFisica pf = new PessoaFisica();
		pf.setNome("João da Silva");
		pf.setCpf("555.555.555-5");
		
		PessoaJuridica pj = new PessoaJuridica();
		pj.setNome("Maria Ferreira");
		pj.setCnpj("666.666.666-6");
		
		em.getTransaction().begin();
		em.persist(pf);
		em.persist(pj);
		em.getTransaction().commit();
		
		Assert.assertNotNull(pf.getId());
		Assert.assertNotNull(pj.getId());
	}
}
