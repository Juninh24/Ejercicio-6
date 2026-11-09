public class Clima extends Widget {
    private String ciudad;
    private double temperatura;

    public Clima(int id, String nombre, int memoriaKB, String ciudad, double temperatura) {
        super(id, nombre, memoriaKB);
        this.ciudad = ciudad;
        this.temperatura = temperatura;
    }

    public String getCiudad() { return ciudad; }
    public double getTemperatura() { return temperatura; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public void setTemperatura(double temperatura) { this.temperatura = temperatura; }

    @Override
    public String renderizar() { return "Clima en " + ciudad + ": " + temperatura + " C"; }

    @Override
    public String getConfiguracion() { return "Ciudad: " + ciudad + ", temperatura: " + temperatura + " C"; }
}
