public class Banner extends Widget {
    private String mensaje;

    public Banner(int id, String nombre, int memoriaKB, String mensaje) {
        super(id, nombre, memoriaKB);
        this.mensaje = mensaje;
    }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    @Override
    public String renderizar() { return "*** " + mensaje + " ***"; }

    @Override
    public String getConfiguracion() { return "Mensaje: " + mensaje; }
}
