package com.bedu.inventario.models;

import com.bedu.inventario.Categoria;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;

@Entity
public class Producto {

//    ID DE TIPO LOG LLAVE PRIMARIA GENERADA AUTOMATICAMENTE E INCREMENTABLE
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

   

    @NotBlank(message="El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message="La descripción no puede estar vacía")
    private String descripcion;
    @Min(value = 1, message = "El precio debe ser al menos 1")
    private double precio;

    protected Producto() {} // Constructor requerido por JPA

    // Dentro del constructor público (debajo de los otros parámetros)
    public Producto(String nombre, String descripcion, double precio, Categoria categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
    }


//    Getters
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }

    // Agregar un getter al final de los métodos de acceso
    public Categoria getCategoria() {
        return categoria;
    }

    // Dentro del método toString(), agrega la categoría de forma opcional
    @Override
    public String toString() {
        return String.format(
                "Producto[id=%d, nombre='%s', precio=%.2f, categoria='%s']",
                id, nombre, precio, categoria != null ? categoria.getNombre() : "Sin categoría"
        );
    }
}
