package com.bedu.inventario.repositories;

import com.bedu.inventario.Categoria;
import com.bedu.inventario.models.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

    // Busca categorías cuyo nombre contenga cierta palabra (sin importar mayúsculas)
    List<Marca> findByNombreContainingIgnoreCase(String nombre);
}
