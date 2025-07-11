package com.algaworks.awpag.domain.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

  @Entity
  @Getter
  @Setter
  @Table(name = "Catalogo")
  public class Catalogo {

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long Id;

     @ManyToOne
     @JoinColumn(name = "catalogador_id")
      private Catalogador catalogador;

      @Size(max = 255)
      private String catalogo;


  }
