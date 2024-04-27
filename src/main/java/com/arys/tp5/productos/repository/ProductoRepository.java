package com.arys.tp5.productos.repository;

import com.arys.tp5.productos.model.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepository extends MongoRepository<Producto, String> {

}