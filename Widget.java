public abstract class Widget implements Renderizable, Comparable<Widget> {
    private int id;
    private String nombre;
    private int memoriaKB;

    public Widget(int id, String nombre, int memoriaKB) {
        this.id = id;
        this.nombre = nombre;
        this.memoriaKB = memoriaKB;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getMemoriaKB() { return memoriaKB; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setMemoriaKB(int memoriaKB) {
        if (memoriaKB > 0) {            // regla de negocio: memoria mayor que 0
            this.memoriaKB = memoriaKB;
        }
    }

    /** Cada widget describe su propia configuración. */
    public abstract String getConfiguracion();

    /** Ordena por memoria (KB) ascendente; si empatan, por ID. */
    @Override
    public int compareTo(Widget otro) {
        int resultado = Integer.compare(this.memoriaKB, otro.memoriaKB);
        if (resultado == 0) {
            resultado = Integer.compare(this.id, otro.id);
        }
        return resultado;
    }

    /** Dos widgets son iguales si tienen el mismo ID. */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Widget)) return false;
        Widget otro = (Widget) obj;
        return this.id == otro.id;
    }

    @Override
    public int hashCode() { return Integer.hashCode(id); }

    @Override
    public String toString() {
        return "[ID " + id + "] " + nombre + " - " + memoriaKB + " KB";
    }
}
