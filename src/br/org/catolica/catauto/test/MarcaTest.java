package br.org.catolica.catauto.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.org.catolica.catauto.bean.DetalheMarca;
import br.org.catolica.catauto.bean.Marca;
import br.org.catolica.catauto.bean.Modelo;
import br.org.catolica.catauto.jpa.JPAUtil;

public class MarcaTest {

	private static EntityManager em;
	private static EntityManager em1; 
	
	@BeforeClass
	public static void begin(){
		em = JPAUtil.getEntityManager();
		em1 = JPAUtil.getEntityManager();
	}
	
	@AfterClass
	public static void end(){
		em.close();
	}

	
	@Test
	public void salvaTest() {
		Marca marca = criaMarca();
		Assert.assertNotNull(marca.getId());
		Assert.assertNotNull(marca.getDetalhe().getId());
	}
	
	@Test
	public void findTest() { 
		Marca marca = em.find(Marca.class, 1L);
		Assert.assertNotNull(marca);
		marca = em1.find(Marca.class, 1L);
		Assert.assertNotNull(marca); 
	}
	

	
	@Test
	public void listaTest() {
		Query query = em.createQuery("select a from Marca a", Marca.class);
		List<Marca> marcas = query.getResultList();
		
		query = em1.createQuery("select a from Marca a", Marca.class);
		marcas = query.getResultList();
		
		Assert.assertTrue(marcas.size() > 0); 
	}
	@Test
	public void removeTest(){
		Marca marca = criaMarca();
		Long id = marca.getId();
		em.getTransaction().begin();
		em.remove(marca);
		em.getTransaction().commit();
		marca = em.find(Marca.class, id);
		Assert.assertNull(marca);
		
	}
	
	
	private Marca criaMarca() {
		Marca marca = new Marca();
		DetalheMarca detalhe = new DetalheMarca();
		marca.setDetalhe(detalhe);
		detalhe.setAnoFundacao(1820);
		detalhe.setFundador("Enzo Ferrari");
		detalhe.setPaisOrigem("Itália");

		marca.setModelos(new ArrayList<Modelo>());
		
		Modelo modelo = new Modelo();
		modelo.setMarca(marca);
		modelo.setNome("F 50");
		marca.getModelos().add(modelo);
		
		modelo = new Modelo();
		modelo.setMarca(marca);
		modelo.setNome("Maranello");
		marca.getModelos().add(modelo);
		
		em.getTransaction().begin();
		em.persist(marca);
		em.getTransaction().commit();
		return marca;
	}
	
	
	
	
	
	

}


