package com.crud.crudApi.service;

import com.crud.crudApi.dto.ProduitDTO;
import com.crud.crudApi.entities.Categorie;
import com.crud.crudApi.entities.Produit;
import com.crud.crudApi.repository.ImageRepository;
import com.crud.crudApi.repository.ProduitRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    ImageRepository imageRepository;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public ProduitDTO saveProduct(ProduitDTO p) {

        var produit = convertDtoToEntity(p);
        return convertEntityToDto(produitRepository.save(produit));
    }


    @Override
    public ProduitDTO updateProduit(ProduitDTO p) {
       /* Long oldProdImageId =
                this.getProduit(p.getIdProduit()).getImage().getIdImage();
        Long newProdImageId = p.getImage().getIdImage();
        var produit = convertDtoToEntity(p);
        ProduitDTO prodUpdated = convertEntityToDto(produitRepository.save(produit));
        if (oldProdImageId != newProdImageId) //si l'image a été modifiée
            imageRepository.deleteById(oldProdImageId);
        return prodUpdated;*/

        var produit = convertDtoToEntity(p);
        ProduitDTO prodUpdated = convertEntityToDto(produitRepository.save(produit));
        return prodUpdated;
    }

    @Override
    public void deleteProduit(Produit p) {

        produitRepository.delete(p);
    }

    @Override
    public void deleteProduitById(Long id) {

        ProduitDTO p = getProduit(id);
//suuprimer l'image avant de supprimer le produit
        try {
            Files.delete(Paths.get(System.getProperty("user.home")+"/imagess/"+p.getImagePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        produitRepository.deleteById(id);
    }


    @Override
    public ProduitDTO getProduit(Long id) {
        return convertEntityToDto(produitRepository.findById(id).get());
    }


    @Override
    public List<ProduitDTO> getAllProduits() {

        return produitRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Produit> findByNomProduit(String nom) {
        return produitRepository.findByNomProduit(nom);
    }

    @Override
    public List<Produit> findByNomProduitContains(String nom) {
        return produitRepository.findByNomProduitContains(nom);
    }

    @Override
    public List<Produit> findByNomPrix(String nom, Double prix) {
        return produitRepository.findByNomPrix(nom, prix);
    }

    @Override
    public List<Produit> findByCategorie(Categorie categorie) {
        return produitRepository.findByCategorie(categorie);
    }

    @Override
    public List<Produit> findByCategorieIdCat(Long id) {
        return produitRepository.findByCategorieIdCat(id);
    }

    @Override
    public List<Produit> findByOrderByNomProduitAsc() {
        return produitRepository.findByOrderByNomProduitAsc();
    }

    @Override
    public List<Produit> trierProduitsNomsPrix() {
        return produitRepository.trierProduitsNomsPrix();
    }

    @Override
    public ProduitDTO convertEntityToDto(Produit p) {

        //modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        ProduitDTO produitDTO = modelMapper.map(p, ProduitDTO.class);

        return produitDTO;
        /*return ProduitDTO.builder()
                .idProduit(p.getIdProduit())
                .nomProduit(p.getNomProduit())
                .dateCreation(p.getDateCreation())
                .prixProduit(p.getPrixProduit())
                .categorie(p.getCategorie())
                .build();*/
    }

    @Override
    public Produit convertDtoToEntity(ProduitDTO produitDTO) {

        Produit produit = new Produit();
        produit = modelMapper.map(produitDTO, Produit.class);
        /*Produit produit = new Produit();
        produit.setIdProduit(produitDTO.getIdProduit());
        produit.setNomProduit(produitDTO.getNomProduit());
        produit.setPrixProduit(produitDTO.getPrixProduit());
        produit.setDateCreation(produitDTO.getDateCreation());
        produit.setCategorie(produitDTO.getCategorie());*/

        return produit;
    }
}
