import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Materiales materiales = new Materiales();

//        Lista de método video
        Video video1 = new Video("Introducción a Java", "Mario", 15);
        Video video2 = new Video("POO en Java", "Carlos", 20);
        List<Video> listaVideo = new ArrayList<>();
        listaVideo.add(video1);
        listaVideo.add(video2);

//        Lista de método Articulo
        Articulo art1 = new Articulo("Historia de Java ", "Ana", 1200);
        Articulo art2 = new Articulo("Tipos de datos ", "Luis", 800);
        List<Articulo> listaArticulo = new ArrayList<>();
        listaArticulo.add(art1);
        listaArticulo.add(art2);

//        Lista de método Ejercicio
        Ejercicio eje1 = new Ejercicio("Variables y tipos", "Luis", false);
        Ejercicio eje2 = new Ejercicio("Condicionales", "Mario", false);
        List<Ejercicio> listaEjercicio = new ArrayList<>();
        listaEjercicio.add(eje1);
        listaEjercicio.add(eje2);


        // Todos los materiales
        List<MaterialCurso> todosMateriales = new ArrayList<>();
        todosMateriales.addAll(listaVideo);
        todosMateriales.addAll(listaArticulo);
        todosMateriales.addAll(listaEjercicio);

        // Mostrar materiales
        System.out.println("📚 Materiales del curso:");
        materiales.mostrarMateriales(todosMateriales);

        // Contar duración videos
        System.out.println();
        materiales.contarDuracionVideos(listaVideo);

        //  Marcar ejercicios como revisados
        System.out.println();
        materiales.marcarEjerciciosRevisados(listaEjercicio);

        //  Filtrar por autor
        System.out.println();
        List<MaterialCurso> filtrados = materiales.filtrarPorAutor(
                todosMateriales,
                m -> m.getAutor().equalsIgnoreCase("Mario")
        );

        System.out.println("🔍 Filtrando materiales por autor:");
        materiales.mostrarMateriales(filtrados);
    }
}