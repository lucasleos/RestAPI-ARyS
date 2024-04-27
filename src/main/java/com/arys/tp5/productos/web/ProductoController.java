package com.arys.tp5.productos.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.arys.tp5.productos.model.Producto;
import com.arys.tp5.productos.service.ProductoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping
    public ResponseEntity<Void> addProducto(@RequestBody Producto producto) {
        String productoId = productoService.addProducto(producto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productoId)
                .toUri();
        return ResponseEntity.created(location)
                .build();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateProducto(@RequestBody Producto producto) {
        productoService.updateProducto(producto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Producto getProducto(@PathVariable String id) {
        return productoService.getProducto(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProducto(@PathVariable String id) {
        productoService.deleteProducto(id);
    }
}