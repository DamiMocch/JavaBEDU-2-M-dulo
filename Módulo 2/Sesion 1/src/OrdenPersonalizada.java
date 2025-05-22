public class OrdenPersonalizada extends OrdenProduccion{
    String cliente;
    private int costoAdicional = 0;

    public OrdenPersonalizada(String codigo, int cantidad, String cliente){
        super(codigo, cantidad);
        this.cliente = cliente;

    }

    public void agregarCostoAdicional(int costo){
        this.costoAdicional += costo;
    }



    public String getCodigo() {
        return codigo;
    }


    @Override
    public void mostrarResumen() {
        System.out.println("🛠️ OrdenPersonalizada - Código: " + codigo + " - Cantidad: " + cantidad + " - Cliente: " + cliente);
    }


}
