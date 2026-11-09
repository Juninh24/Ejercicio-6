public class Calendario extends Widget implements Interactivo {
    private String mes;
    private int diaSeleccionado;

    public Calendario(int id, String nombre, int memoriaKB, String mes) {
        super(id, nombre, memoriaKB);
        this.mes = mes;
        this.diaSeleccionado = 1;
    }

    public String getMes() { return mes; }
    public int getDiaSeleccionado() { return diaSeleccionado; }

    @Override
    public String renderizar() { return "Calendario de " + mes + " (día " + diaSeleccionado + ")"; }

    @Override
    public String responderClic() {
        diaSeleccionado++;
        return "Día seleccionado: " + diaSeleccionado + " de " + mes;
    }

    @Override
    public String getConfiguracion() { return "Mes: " + mes + ", día seleccionado: " + diaSeleccionado; }
}
