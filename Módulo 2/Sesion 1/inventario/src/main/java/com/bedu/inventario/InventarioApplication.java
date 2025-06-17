package com.bedu.inventario;

import com.bedu.inventario.models.Producto;
import com.bedu.inventario.repositories.CategoriaRepository;
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
	public CommandLineRunner demo(ProductoRepository productoRepo, CategoriaRepository categoriaRepo) {
		return (args) -> {

			// 🧪 Guardar al menos 4 productos

			Categoria tecnologia = new Categoria("Tecnología");
			categoriaRepo.save(tecnologia);
			productoRepo.save(new Producto("Laptop Lenovo", "AMD Ryzen 7, 16GB RAM", 18500.0, tecnologia));
			productoRepo.save(new Producto("Laptop ASUS ROG Strix SCAR 18", "Intel Core i9, RTX 5090", 90000.00, tecnologia));
			productoRepo.save(new Producto("Laptop MSI Titan 18 HX", "Intel Core i9, RTX 4090", 140000.00, tecnologia));
			productoRepo.save(new Producto("Tablet Lenovo", "Pantalla 10 pulgadas", 780.00, tecnologia));
			productoRepo.save(new Producto("Macbook", "IOS", 780.00, tecnologia));

			System.out.println("📂 Productos registrados:");
			productoRepo.findAll().forEach(p -> System.out.println(p.getNombre() + " - " + p.getCategoria().getNombre()));

			System.out.println("\n📦 Productos con precio mayor a 500: ");
			productoRepo.findByPrecioGreaterThan(500).forEach(System.out::println);

//			Productos que contienen "lap"
			System.out.println("\n🔍 Productos que contienen 'lap': ");
			productoRepo.findByNombreContainingIgnoreCase("lap").forEach(System.out::println);

//			Precio entre 400 y 1000
			System.out.println("\n🔍 Productos con precio entre 400 y 1000: ");
			productoRepo.findByPrecioBetween(400,1000).forEach(System.out::println);

//			Nombre empieza con "m"
			System.out.println("\n🔍 Productos cuyo nombre empieza con 'm': ");
			productoRepo.findByNombreStartingWithIgnoreCase("m").forEach(System.out::println);
		};
	}
}