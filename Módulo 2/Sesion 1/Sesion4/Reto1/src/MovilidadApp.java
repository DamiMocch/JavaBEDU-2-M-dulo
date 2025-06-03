import java.util.concurrent.CompletableFuture;
import java.util.concurrent.*;

public class MovilidadApp {

public static void main(String[] args) {


//    Método CompletableFuture<String>
//    Retorna un mensaje como "Ruta: Centro -> Norte"
    CompletableFuture<String> rutaFuture = obtenerRuta();

//    Método ComplatableFuture<Double>
//    Retorna un valor numerico como 75.50
    CompletableFuture<Double> tarifaFuture = obtenerTarifa();

//    Método para combinar ambas operaciones
    CompletableFuture<Void> rutaTarifa = rutaFuture.thenCombine(tarifaFuture,
            (ruta, tarifa) -> {
        return "🛣️ Ruta caculada: " + ruta + " | Tarifa: " + tarifa;
            })
            .thenAccept(System.out::println)
            .exceptionally(ex -> {
                System.out.println("Error al calcular la ruta: " + ex.getMessage());
                return null;
            });

//    Esperar que todo termine
    rutaTarifa.join();
}

// Simula calcular la ruta optima (latencia de 1.2 segundos)
    public static CompletableFuture<String> obtenerRuta(){
    return CompletableFuture.supplyAsync(() -> {
        System.out.println("🚦Calculando ruta...");
//        Latencia simulada
        dormir(3);
        return "Ruta: Centro -> Norte";
    });
    }

//   Simula la estimación de la tarifa (latencia de 1-2 segundos).
public static CompletableFuture<Double> obtenerTarifa(){
    return CompletableFuture.supplyAsync(() -> {
        System.out.println("💵 Estimando tarifa...");
        dormir(2);

        String tarifaTexto = "$75.50";

        // Eliminar el signo de pesos y convertir a Double
        double tarifa = Double.parseDouble(tarifaTexto.replace("$", ""));

        return tarifa;
    });
}

//    Método auxiliar para simular latencia
    public static void dormir(int segundos){
    try{
        TimeUnit.SECONDS.sleep(segundos);
    }catch (InterruptedException e){
        Thread.currentThread().interrupt();
    }
    }


}


