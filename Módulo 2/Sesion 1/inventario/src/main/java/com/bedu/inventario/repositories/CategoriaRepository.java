package com.bedu.inventario.repositories;

import com.bedu.inventario.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    // Busca categorías cuyo nombre contenga cierta palabra (sin importar mayúsculas)
    List<Categoria> findByNombreContainingIgnoreCase(String nombre);
}
