import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Materiales {

//    Método generico muestre el detalle de todos los materiales
    public void mostrarMateriales(List<? extends MaterialCurso> lista){
        System.out.println();
        lista.forEach(MaterialCurso::mostrarDetalle);
    }

//    Método generico que suma y muestra la duración total de los videos
    public void contarDuracionVideos(List<? extends Video> lista) {
        int total = 0;
        for (Video video : lista){
            total += video.getDuracion();
        }
        System.out.println("📽️ Duración total de videos: " + total + "minutos");

    }

//    Método generico que actualiza el estado de los ejercicios a revisado=true y muestra
//    un mensaje por cada uno
    public void marcarEjerciciosRevisados(List<? super Ejercicio> lista){
        for (Object obj : lista) {
            if (obj instanceof Ejercicio) {
                Ejercicio ejercicio = (Ejercicio) obj;
                ejercicio.setRevisado(true);
                System.out.println("✅ Ejercicio '" + ejercicio.titulo + "' marcado como revisado.");
            }
        }
    }

//    Método generico que filtre materiales por autor
    public List<MaterialCurso> filtrarPorAutor(List<? extends MaterialCurso> lista, Predicate<MaterialCurso> filtro) {
        return lista.stream()
                .filter(filtro)
                .collect(Collectors.toList());
    }
}
