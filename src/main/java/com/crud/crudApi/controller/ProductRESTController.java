package com.crud.crudApi.controller;

import com.crud.crudApi.dto.ProduitDTO;
import com.crud.crudApi.entities.Produit;
import com.crud.crudApi.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
@AllArgsConstructor
public class ProductRESTController {

    ProductService productService;

    @GetMapping("/all")
    public List<ProduitDTO>  getAllProducts(){
        return productService.getAllProduits();
    }

    @GetMapping("/getbyid/{id}")
    public ProduitDTO getProductById(@PathVariable Long id){
        return productService.getProduit(id);
    }

    @PostMapping("/addprod")
    public ProduitDTO createProduct(@RequestBody ProduitDTO produitDTO){
        return productService.saveProduct(produitDTO);
    }

    @PutMapping("/updateprod")
    public ProduitDTO updateProduct(@RequestBody ProduitDTO produitDTO){
        return productService.updateProduit(produitDTO);
    }

    @DeleteMapping("/delprod/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduitById(id);
    }

    @GetMapping("/prodscat/{idCat}")
    public List<Produit> getProduitsByCatId(@PathVariable Long idCat){
        return productService.findByCategorieIdCat(idCat);
    }

    @GetMapping("/prodsByName/{nom}")
    public List<Produit> findByNomProduitContains(@PathVariable String nom){
        return productService.findByNomProduitContains(nom);
    }
}
