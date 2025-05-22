import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Ordenes ordenes = new Ordenes();

//        Ordenes de producción de masa
        OrdenMasa ordenM1 = new OrdenMasa("A1739", 500);
        OrdenMasa ordenM2 = new OrdenMasa("A4851", 750);
        List<OrdenMasa> listaMasa = new ArrayList<>();
        listaMasa.add(ordenM1);
        listaMasa.add(ordenM2);

//        Ordenes personalizadas
        OrdenPersonalizada ordenP1 = new OrdenPersonalizada("P2394", 740, "ClienteY");
        OrdenPersonalizada ordenP2 = new OrdenPersonalizada("P4843", 150, "Clientex");
        List<OrdenPersonalizada> listaPerso = new ArrayList<>();
        listaPerso.add(ordenP1);
        listaPerso.add(ordenP2);

//        Ordenes prototipo
        OrdenPrototipo ordenPro1 = new OrdenPrototipo("T674", 10, "Diseño");
        OrdenPrototipo ordenPro2 = new OrdenPrototipo("T368", 15, "Pruebas");
        List<OrdenPrototipo> listaPrototipo = new ArrayList<>();
        listaPrototipo.add(ordenPro1);
        listaPrototipo.add(ordenPro2);

//        Mostrar órdenes
        System.out.println("📋 Órdenes registradas: ");
        ordenes.mostrarOrdenes(listaMasa);

        System.out.println("\n 📋 Órdenes registradas: ");
        ordenes.mostrarOrdenes(listaPrototipo);

        System.out.println("\n 📋 Órdenes registradas: ");
        ordenes.mostrarOrdenes(listaPerso);

//        Procesar órdenes personalizadas
        Ordenes.procesarPersonalizadas(listaPerso, 200);

//        Resumen total
        // 📊 Resumen total
        System.out.println("\n📊 Resumen total de órdenes:");
        System.out.println("🔧 Producción en masa: " + listaMasa.size());
        System.out.println("🛠️ Personalizadas: " + listaPerso.size());
        System.out.println("🧪 Prototipos: " + listaPrototipo.size());




    }
}