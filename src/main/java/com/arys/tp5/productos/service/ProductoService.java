package com.arys.tp5.productos.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.arys.tp5.productos.exception.ProductoNotFoundException;
import com.arys.tp5.productos.model.Producto;
import com.arys.tp5.productos.repository.ProductoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductoService {

    private final ProductoRepository productoRepository;

    public String addProducto(Producto producto) {
        return productoRepository.insert(producto).getId();
    }

    public void updateProducto(Producto producto) {
        Producto savedProducto = productoRepository.findById(producto.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        String.format("Cannot Find Producto by ID %s", producto.getId())));

        savedProducto.setNombre(producto.getNombre());
        savedProducto.setDescripcion(producto.getDescripcion());
        savedProducto.setPrecio(producto.getPrecio());
        productoRepository.save(savedProducto);
    }

    public Producto getProducto(String id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNotFoundException(String.format("Cannot Find Producto by ID - %s", id)));

        return producto;
    }

    public List<Producto> getAllProductos() {
        return productoRepository.findAll()
                .stream().collect(Collectors.toList());
    }

    public void deleteProducto(String id) {
        productoRepository.deleteById(id);
    }
}