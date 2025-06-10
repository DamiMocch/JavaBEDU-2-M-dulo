package com.MeridianPrime.MeridianPrime;

import reactor.core.publisher.Flux;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MeridianPrimeApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(MeridianPrimeApplication.class, args);


		AtomicInteger eventosCriticosSimultaneos = new AtomicInteger(0);

		//	Crear 5 flujos Flux independientes, cada uno simulando un sistema critico
//	Sensores de tráfico
		Flux<String> sensoresTrafico = Flux.interval(Duration.ofMillis(500))
				.map(i -> (int) (Math.random() * 101))
				.take(5)
				.onBackpressureBuffer()
				.filter(nivel -> nivel > 70)
				.map(nivel -> "🚗 Alerta: Congestión del " + nivel + "% en Avenida Solar");
		sensoresTrafico.subscribe(System.out::println);


		//	Contaminación del aire
		Flux<String> contaminacionAire = Flux.interval(Duration.ofMillis(600))
				.map(i -> (int) (Math.random() * 100)) // Nivel de partículas PM2.5 (ug/m3)
				.take(5)
				.onBackpressureBuffer() // Backpressure para evitar overflow
				.filter(nivel -> nivel > 50) // Evento crítico: superior a 50 ug/m3
				.map(nivel -> "🌫️ Alerta: Contaminación alta (PM2.5: " + nivel + " ug/m3)");
		contaminacionAire.subscribe(System.out::println);

		//	Accidentes viales
		Flux<String> accidentesViales = Flux.interval(Duration.ofMillis(800))
				.map(i -> {
					int val = (int) (Math.random() * 3);
					switch (val) {
						case 0: return "Baja";
						case 1: return "Media";
						default: return "Alta";
					}
				})
				.take(5)
				.filter(prioridad -> prioridad.equals("Alta"))
				.map(prioridad -> "🚑 Emergencia vial: Accidente con prioridad " + prioridad + " en Zona Industrial");
		accidentesViales.subscribe(System.out::println);


		//	Trenes maglev
		Flux<String> trenesMaglev = Flux.interval(Duration.ofMillis(700))
				.map(i -> (int) (Math.random() * 10))
				.take(5)
				.onBackpressureBuffer()
				.filter(retraso -> retraso > 5)
				.delayElements(Duration.ofMillis(300))  // Simula procesamiento lento -> backpressure
				.map(retraso -> "🚝 Tren maglev con retraso crítico: " + retraso + " minutos en estación Central");
		trenesMaglev.subscribe(System.out::println);


		//	Semáforos inteligentes
		Flux<String> semaforosInteligentes = Flux.interval(Duration.ofMillis(400))
				.map(i -> {
					int val = (int) (Math.random() * 3);
					switch (val) {
						case 0:
							return "Verde";
						case 1:
							return "Amarillo";
						default:
							return "Rojo";
					}
				})
				.take(10)
				.buffer(4, 1)
				.filter(ventana -> ventana.stream().filter(s -> s.equals("Rojo")).count() > 3)
				.map(ventana -> "🚦 Semáforo en Rojo detectado 3 veces seguidas en cruce Norte");
				semaforosInteligentes.subscribe(System.out::println);

//				Combinación
		Flux<String> eventosCriticos = Flux.merge(
				sensoresTrafico,
				contaminacionAire,
				accidentesViales,
				trenesMaglev,
				semaforosInteligentes
		);

		eventosCriticos.subscribe(evento -> System.out.println(evento));

		eventosCriticos
				.window(Duration.ofSeconds(1))
				.flatMap(ventana -> ventana.collectList())
				.filter(lista -> lista.size() >= 3)
				.subscribe(lista -> {
					System.out.println("\n🚨 ALERTA GLOBAL: Múltiples eventos críticos detectados en Meridian Prime 🚨");
					System.out.println("───────────────────────────────────────────────\n");
				});

		// Para que el programa no termine inmediatamente
		Thread.sleep(15000);


	}


}
