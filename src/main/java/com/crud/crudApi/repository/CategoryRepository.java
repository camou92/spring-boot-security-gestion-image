package com.crud.crudApi.repository;

import com.crud.crudApi.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "cat")
@CrossOrigin("*")
public interface CategoryRepository extends JpaRepository<Categorie, Long> {
}
