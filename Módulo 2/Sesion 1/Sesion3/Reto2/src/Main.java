import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Lista de sucursales con sus encuestas
        List<Sucursal> sucursales = List.of(
                new Sucursal("Centro", List.of(
                        new Encuesta("Antonio", null, 4),
                        new Encuesta("Juan", "El tiempo de espera fue largo", 3),
                        new Encuesta("Maria", "null", 5),
                        new Encuesta("Juan", "La atención fue buena, pero la limpieza puede mejorar", 3)
                )),
                new Sucursal("Norte", List.of(
                        new Encuesta("Luis", null, 4),
                        new Encuesta("Jaime", null, 5),
                        new Encuesta("Karla", "La atención no fue la adecuada", 2)
                ))
        );


//        Procesamos todo de todas las sucursales
        sucursales.stream()
                .flatMap(sucursal ->
                        sucursal.getEncuestas().stream()
                                .filter(encuesta -> encuesta.getCalificacion() <= 3)
                                .flatMap(encuesta -> encuesta.getComentario()
                                        .filter(c -> !c.equalsIgnoreCase("null")) // evita comentarios "null" como texto
                                        .map(comentario ->
                                                "Sucursal " + sucursal.getNombre() + ": Seguimiento a paciente con comentario: \"" + comentario + "\""
                                        )
                                        .stream()
                                )
                )
                .forEach(System.out::println);
    }
}