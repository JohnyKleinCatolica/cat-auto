package br.org.catolica.catauto.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.org.catolica.catauto.bean.Automovel;
import br.org.catolica.catauto.bean.DetalheMarca;
import br.org.catolica.catauto.bean.Marca;
import br.org.catolica.catauto.bean.Modelo;
import br.org.catolica.catauto.jpa.JPAUtil;

public class AutomovelTest {

	private static EntityManager em; 
	
	@BeforeClass
	public static void begin(){
		em = JPAUtil.getEntityManager();
	}
	
	@AfterClass
	public static void end(){
		em.close(); 
	}

	
	@Test
	public void salvaTest() {
		Automovel auto = criaAutomovel();
		Assert.assertNotNull(auto.getId());
	}
	@Test
	public void listaTest() {
		criaAutomovel();
		Query query = em.createNamedQuery(Automovel.LISTAR_DESTAQUES);
		List<Automovel> autos = query.getResultList();
		Assert.assertTrue(autos.size() > 0); 
	}
	@Test
	public void removeTest(){
		Automovel auto = criaAutomovel();
		Long id = auto.getId();
		em.getTransaction().begin();
		em.remove(auto);
		em.getTransaction().commit();
		auto = em.find(Automovel.class, id);
		Assert.assertNull(auto);
		
	}
	
	
	private static Automovel criaAutomovel() {
		Automovel auto = new Automovel();
		Marca marca = new Marca();
		marca.setNome("Ferrari");
		marca.setDetalhe(new DetalheMarca());
		marca.getDetalhe().setAnoFundacao(1850);
		marca.getDetalhe().setFundador("Enzo Ferrari");
		marca.getDetalhe().setPaisOrigem("Itália");
		Modelo modelo = new Modelo();
		modelo.setMarca(marca);
		modelo.setNome("F50");
		auto.setAnoFabricacao(2010);
		auto.setModelo(modelo);
		auto.setObservacoes("Nunca foi batido");
		em.getTransaction().begin();
		em.persist(marca);
		em.persist(modelo);
		em.persist(auto);
		em.getTransaction().commit();
		return auto;
	}
	
	public static void main(String[] args) {
		criaAutomovel();
	}

}

