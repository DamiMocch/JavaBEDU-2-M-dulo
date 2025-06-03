import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.*;

public class AeropuertoControl {
    public static void main(String[] args) {
        System.out.println("🛫 Verificando condiciones para aterrizaje...\n");

//    Métodos
        CompletableFuture<Boolean> pistaFuture = verificarPista();
        CompletableFuture<Boolean> climaFuture = verificarClima();
        CompletableFuture<Boolean> traficoFuture = verificarTraficoAereo();
        CompletableFuture<Boolean> personalFuture = verificarPersonalTierra();

//        Método combina los resultados usando thenCombine
//        theCombineAsync o allOf para decidir si se autoriza el aterrizaje
        // Combinar todas las verificaciones
        CompletableFuture<Void> autorizacion = CompletableFuture.allOf(pistaFuture, climaFuture, traficoFuture, personalFuture)
                .thenRun(() -> {
                    try {
                        // Obtener resultados individuales
                        boolean pista = pistaFuture.get();
                        boolean clima = climaFuture.get();
                        boolean trafico = traficoFuture.get();
                        boolean personal = personalFuture.get();

                        // Verificar si todas las condiciones son positivas
                        if (pista && clima && trafico && personal) {
                            System.out.println("\n🛬 Aterrizaje autorizado: Todas las condiciones son óptimas.");
                        } else {
                            System.out.println("\n🚫 Aterrizaje denegado: Condiciones no óptimas.");
                        }

                    } catch (InterruptedException | ExecutionException e) {
                        System.out.println("🚨 Error al obtener los resultados: " + e.getMessage());
                    }
                });

        // Esperar a que todo termine
        autorizacion.join();
    }



//    Cada método debe simular latencia (2-3 segundos) y devolver true si el servicio es favorable.
//   VERIFICAR PISTA
        public static CompletableFuture<Boolean> verificarPista () {
            return CompletableFuture.supplyAsync(() -> {
                //        Latencia simulada
                dormir(3);
                boolean resultado = new Random().nextBoolean();
                System.out.println("🛣️ Pista disponible: " + resultado);
                return resultado;
            });
        }

        //   CLIMA PISTA
        public static CompletableFuture<Boolean> verificarClima () {
            return CompletableFuture.supplyAsync(() -> {
                //        Latencia simulada
                dormir(2);
                boolean resultado = new Random().nextBoolean();
                System.out.println("🌥️️ Clima favorable: " + resultado);
                return resultado;
            });
        }

        //   TRÁFICO AÉREO
        public static CompletableFuture<Boolean> verificarTraficoAereo () {
            return CompletableFuture.supplyAsync(() -> {
                //        Latencia simulada
                dormir(3);
                boolean resultado = new Random().nextBoolean();
                System.out.println("🚦 Tráfico aéreo despejado: " + resultado);
                return resultado;
            });
        }

        //   PERSONAL DISPONIBLE
        public static CompletableFuture<Boolean> verificarPersonalTierra () {
            return CompletableFuture.supplyAsync(() -> {
                //        Latencia simulada
                dormir(3);
                boolean resultado = new Random().nextBoolean();
                System.out.println("👷🏻‍♂️ Personal disponible: " + resultado);
                return resultado;
            });

        }

    //    Método auxiliar para simular latencia
    public static void dormir (int segundos){
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }



}
