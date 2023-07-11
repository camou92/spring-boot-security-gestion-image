package com.crud.crudApi.service;

import com.crud.crudApi.dto.ProduitDTO;
import com.crud.crudApi.entities.Categorie;
import com.crud.crudApi.entities.Produit;

import java.util.List;

public interface ProductService {

    ProduitDTO saveProduct(ProduitDTO p);

    ProduitDTO getProduit(Long id);



    List<ProduitDTO> getAllProduits();
    ProduitDTO updateProduit(ProduitDTO p);

    void deleteProduit(Produit p);

    void deleteProduitById(Long id);

    List<Produit> findByNomProduit(String nom);
    List<Produit> findByNomProduitContains(String nom);
    List<Produit> findByNomPrix (String nom, Double prix);
    List<Produit> findByCategorie (Categorie categorie);
    List<Produit> findByCategorieIdCat(Long id);
    List<Produit> findByOrderByNomProduitAsc();
    List<Produit> trierProduitsNomsPrix();
    ProduitDTO convertEntityToDto(Produit p);

    Produit convertDtoToEntity(ProduitDTO produitDTO);

}
