import java.util.ArrayList;
import java.util.Collections;

public class Dashboard {
    private ArrayList<Widget> widgets;   

    public Dashboard() {
        widgets = new ArrayList<>();
    }

    public ArrayList<Widget> getWidgets() { return widgets; }

    public boolean agregar(Widget w) {
        if (w == null || widgets.contains(w)) {
            return false;
        }
        return widgets.add(w);
    }

    public Widget buscar(int id) {
        for (Widget w : widgets) {
            if (w.getId() == id) return w;
        }
        return null;
    }

    public Widget buscar(String nombre) {
        for (Widget w : widgets) {
            if (w.getNombre().equalsIgnoreCase(nombre)) return w;
        }
        return null;
    }

    public void ordenarPorMemoria() {
        Collections.sort(widgets);
    }

    public String renderizarTodos() {
        String resultado = "";
        for (Widget w : widgets) {
            resultado += dibujar(w) + "\n";
        }
        return resultado;
    }

    public String clicEnTodos() {
        String resultado = "";
        for (Widget w : widgets) {
            if (w instanceof Interactivo) {
                Interactivo i = (Interactivo) w;
                resultado += w.getNombre() + " -> " + ejecutarClic(i) + "\n";
            } else {
                resultado += w.getNombre() + " -> no soporta interacción (omitido)\n";
            }
        }
        return resultado;
    }

    private String dibujar(Renderizable r) { return r.renderizar(); }
    private String ejecutarClic(Interactivo i) { return i.responderClic(); }
}
