import java.util.List;

public class Ordenes {

    // Método genérico para mostrar órdenes (funciona bien)
    public void mostrarOrdenes(List<? extends OrdenProduccion> lista) {
        System.out.println();
        lista.forEach(OrdenProduccion::mostrarResumen);
    }

    // Método para procesar órdenes personalizadas
    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional) {
        System.out.println("\n 💰 Procesando órdenes personalizadas...");
        for (Object obj : lista) {
            if (obj instanceof OrdenPersonalizada) {
                OrdenPersonalizada op = (OrdenPersonalizada) obj;
                op.agregarCostoAdicional(costoAdicional);
                System.out.println("✅ Orden " + op.getCodigo() + " ajustada con costo adicional de $" + costoAdicional);
            }
        }
    }
}
