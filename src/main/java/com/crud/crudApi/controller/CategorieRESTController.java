package com.crud.crudApi.controller;

import com.crud.crudApi.entities.Categorie;
import com.crud.crudApi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cat")
@CrossOrigin("*")
public class CategorieRESTController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping
    public List<Categorie> getAllCategories(){
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Categorie getCategorieById(@PathVariable Long id) {
        return categoryRepository.findById(id).get();
    }
}
