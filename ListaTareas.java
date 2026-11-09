import java.util.ArrayList;

public class ListaTareas extends Widget implements Interactivo {
    private ArrayList<String> tareas;
    private int completadas;

    public ListaTareas(int id, String nombre, int memoriaKB, ArrayList<String> tareas) {
        super(id, nombre, memoriaKB);
        this.tareas = tareas;
        this.completadas = 0;
    }

    public ArrayList<String> getTareas() { return tareas; }
    public int getCompletadas() { return completadas; }

    @Override
    public String renderizar() {
        return "Tareas: " + completadas + "/" + tareas.size() + " completadas";
    }

    @Override
    public String responderClic() {
        if (completadas < tareas.size()) {
            completadas++;
            return "Tarea completada: " + tareas.get(completadas - 1);
        }
        return "No quedan tareas pendientes.";
    }

    @Override
    public String getConfiguracion() { return "Tareas: " + tareas; }
}
