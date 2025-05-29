import java.util.Optional;

public class Pedido {

    private final String cliente;
    private final String tipoEntrega;
    //    Puede ser nulo
    private final String telefono;

    // Costructor
    public Pedido(String cliente, String tipoEntrega, String telefono){
        this.cliente = cliente;
        this.tipoEntrega = tipoEntrega;
        this.telefono = telefono;
    }

    public String getCliente() {
        return cliente;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    //    Método de getTelefono() que devuelva un Optional<String>
    public Optional<String> getTelefono(){
        return Optional.ofNullable(telefono);
    }

    @Override
    public String toString(){
        return  cliente + "(Tipo de entrega: " + tipoEntrega + ")";
    }

}
