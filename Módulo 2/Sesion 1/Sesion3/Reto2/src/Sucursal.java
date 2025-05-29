import java.util.List;

public class Sucursal {
    private final String nombre;
    private final List<Encuesta> encuestas;

//    Constructor
    public Sucursal(String nombre, List<Encuesta> encuestas){
        this.nombre = nombre;
        this.encuestas = encuestas;
    }

    public String getNombre() {
        return nombre;
    }

//    Lista de encuestas (List<Encuesta>)
    public List<Encuesta> getEncuestas() {
        return encuestas;
    }
}
