package com.arys.tp5.productos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("producto")
public class Producto {

    @Id
    @Pattern(regexp = "[A-Za-z0-9]+")
    private String id;

    @NotBlank
    @Pattern(regexp = "[a-zA-Z]")
    private String nombre;

    private String descripcion;

    @Min(value = 0)
    private double precio;
}