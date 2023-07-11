package com.crud.crudApi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImage ;
    private String name ;
    private String type ;
    @Column( name = "IMAGE" , length = 4048576 )
    @Lob
    private byte[] image;
    /*@OneToOne
    private Produit produit;*/

    @ManyToOne()
    @JoinColumn (name="PRODUIT_ID")
    @JsonIgnore
    private Produit produit;
}
