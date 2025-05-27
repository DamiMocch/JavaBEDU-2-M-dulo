public class Ejercicio extends MaterialCurso{
    private boolean revisado;

    public Ejercicio(String titulo, String autor, boolean revisado){
        super(titulo, autor);
        this.revisado = false;
    }

    public void setRevisado(boolean revisado) {
        this.revisado = revisado;
    }

    @Override
    public void mostrarDetalle(){
        System.out.println("📝 Ejercicio: " + titulo + "- Autor: " + autor + "- Revisado: " + revisado);

    }
}
