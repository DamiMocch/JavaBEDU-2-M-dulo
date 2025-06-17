package com.bedu.inventario;

import com.bedu.inventario.models.Producto;
import com.bedu.inventario.models.Marca;
import com.bedu.inventario.repositories.CategoriaRepository;
import com.bedu.inventario.repositories.MarcaRepository;
import com.bedu.inventario.repositories.ProductoRepository;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductoRepository productoRepo, CategoriaRepository categoriaRepo, MarcaRepository marcaRepo) {
		return (args) -> {

			// ✅ Crea marcas como objetos y luego guárdalos
			Marca hp = new Marca("HP");
			Marca lenovo = new Marca("Lenovo");
			Marca apple = new Marca("Apple");
			Marca asus = new Marca("Asus");

			marcaRepo.save(hp);
			marcaRepo.save(lenovo);
			marcaRepo.save(apple);
			marcaRepo.save(asus);

			// ✅ Crea una categoría
			Categoria tecnologia = new Categoria("Tecnología");
			categoriaRepo.save(tecnologia);

			// ✅ Guarda productos asociados a marcas y categoría
			productoRepo.save(new Producto("Laptop Lenovo", "AMD Ryzen 7, 16GB RAM", 18500.0, tecnologia, lenovo));
			productoRepo.save(new Producto("Laptop ASUS ROG Strix SCAR 18", "Intel Core i9, RTX 5090", 90000.00, tecnologia, asus));
			productoRepo.save(new Producto("Laptop MSI Titan 18 HX", "Intel Core i9, RTX 4090", 140000.00, tecnologia, hp));
			productoRepo.save(new Producto("Tablet Lenovo", "Pantalla 10 pulgadas", 780.00, tecnologia, lenovo));
			productoRepo.save(new Producto("Macbook", "iOS", 45000.00, tecnologia, apple));

			// ✅ Muestra los productos agrupados por marca
			System.out.println("📚 Productos por marca:");
			marcaRepo.findAll().forEach(marca -> {
				System.out.println("🏷️ " + marca.getNombre() + ":");
				productoRepo.findAll().stream()
						.filter(p -> p.getMarca() != null && p.getMarca().getId().equals(marca.getId()))
						.forEach(p -> System.out.println("   - " + p.getNombre()));
			});


		};
	}

}