public class Alerta extends Widget implements Interactivo {
    private String mensaje;
    private boolean descartada;

    public Alerta(int id, String nombre, int memoriaKB, String mensaje) {
        super(id, nombre, memoriaKB);
        this.mensaje = mensaje;
        this.descartada = false;
    }

    public String getMensaje() { return mensaje; }
    public boolean isDescartada() { return descartada; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    @Override
    public String renderizar() {
        return descartada ? "Alerta descartada" : "ALERTA: " + mensaje;
    }

    @Override
    public String responderClic() {
        descartada = !descartada;
        return descartada ? "Alerta descartada." : "Alerta reactivada.";
    }

    @Override
    public String getConfiguracion() { return "Mensaje: " + mensaje + ", descartada: " + descartada; }
}
