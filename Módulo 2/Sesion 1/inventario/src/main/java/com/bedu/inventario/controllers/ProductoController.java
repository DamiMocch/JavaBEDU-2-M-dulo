package com.bedu.inventario.controllers;


import com.bedu.inventario.models.Producto;
import com.bedu.inventario.services.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService servicio;

    public ProductoController(ProductoService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Producto> obtenerProductos() {
        return servicio.obtenerTodos();
    }

    @PostMapping
    public Producto crearProducto(@Valid @RequestBody Producto producto) {
        return servicio.guardar(producto);
    }




}