package com.crud.crudApi;

import com.crud.crudApi.entities.Categorie;
import com.crud.crudApi.entities.Produit;
import com.crud.crudApi.repository.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class CrudApiApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;

	@Test
	public void testCreateProduct(){
		Produit prod = new Produit("Macbook", 2300.500, new Date());
		produitRepository.save(prod);
	}

	@Test
	public void testFindProduct(){
		Produit p = produitRepository.findById(1L).get();
		System.out.println(p);
	}

	@Test
	public void testUpdateProduct(){
		Produit p = produitRepository.findById(1L).get();
		p.setPrixProduit(2000.0);
		produitRepository.save(p);
		System.out.println(p);
	}

	public void testDeleteProduct(){
		produitRepository.deleteById(1L);
	}
	@Test
	public void testFindAllProducts(){
		List<Produit> prods = produitRepository.findAll();

		prods.forEach(System.out::println);
	}

	@Test
	public void testFindProduitByNom(){
		List<Produit> prods = produitRepository.findByNomProduit("PC Asus");

		prods.forEach(System.out::println);
	}

	@Test
	public void testFindProduitByNomContains(){
		List<Produit> prods = produitRepository.findByNomProduitContains("P");

		prods.forEach(System.out::println);
	}

	@Test
	public void testFindByNomPrix(){
		List<Produit> prods = produitRepository.findByNomPrix("PC Dell", 1500.00);

		prods.forEach(System.out::println);
	}

	@Test
	public void testFindByCategorie(){
		Categorie cat = new Categorie();
		cat.setIdCat(1L);

		List<Produit> prods = produitRepository.findByCategorie(cat);
		prods.forEach(System.out::println);
	}

	@Test
	public void findByCategorieIdCat(){
		List<Produit> prods = produitRepository.findByCategorieIdCat(1L);
		prods.forEach(System.out::println);
	}

	@Test
	public void testFindByOrderByNomProduitASC(){
		List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();
		prods.forEach(System.out::println);
	}

	@Test
	public void trierProdctsNamePrice(){
		List<Produit> prods = produitRepository.trierProduitsNomsPrix();
		prods.forEach(System.out::println);
	}
}
