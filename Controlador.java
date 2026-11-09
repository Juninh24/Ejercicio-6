import java.util.ArrayList;

public class Controlador {
    private Dashboard dashboard;
    private Vista vista;

    public Controlador() {
        dashboard = new Dashboard();
        vista = new Vista();
        cargarCatalogoInicial();
    }

    private void cargarCatalogoInicial() {
        ArrayList<String> trabajo = new ArrayList<>();
        trabajo.add("Entregar ejercicio 6");
        trabajo.add("Estudiar para el parcial");
        trabajo.add("Revisar el repositorio");
        ArrayList<String> personal = new ArrayList<>();
        personal.add("Comprar víveres");
        personal.add("Llamar a casa");

        dashboard.agregar(new Reloj(1, "Reloj Guatemala", 80, "America/Guatemala"));
        dashboard.agregar(new Reloj(2, "Reloj UTC", 75, "UTC"));
        dashboard.agregar(new Clima(3, "Clima Guatemala", 320, "Ciudad de Guatemala", 24.5));
        dashboard.agregar(new Clima(4, "Clima Antigua", 300, "Antigua Guatemala", 21.0));
        dashboard.agregar(new Banner(5, "Banner Bienvenida", 600, "Bienvenido al Dashboard"));
        dashboard.agregar(new ListaTareas(6, "Tareas Trabajo", 450, trabajo));
        dashboard.agregar(new ListaTareas(7, "Tareas Personal", 430, personal));
        dashboard.agregar(new Alerta(8, "Alerta Sistema", 120, "Servidor con carga alta"));
        dashboard.agregar(new Alerta(9, "Alerta Seguridad", 130, "Intento de acceso fallido"));
        dashboard.agregar(new Calendario(10, "Calendario", 510, "Noviembre"));
    }

    public String mostrarMenu() { return vista.menu(); }

    public String listar() { return vista.lista(dashboard.getWidgets()); }

    public String buscarPorId(int id) {
        Widget w = dashboard.buscar(id);                 // llama al buscar(int)
        return (w == null) ? vista.noEncontrado("ID " + id) : vista.detalle(w);
    }

    public String buscarPorNombre(String nombre) {
        Widget w = dashboard.buscar(nombre);             // llama al buscar(String)
        return (w == null) ? vista.noEncontrado("nombre \"" + nombre + "\"") : vista.detalle(w);
    }

    public String ordenarPorMemoria() {
        dashboard.ordenarPorMemoria();
        return vista.titulo("Ordenados por memoria (KB)") + vista.lista(dashboard.getWidgets());
    }

    public String renderizarTodos() {
        return vista.titulo("Renderizado") + dashboard.renderizarTodos();
    }

    public String clicEnTodos() {
        return vista.titulo("Clic en todos") + dashboard.clicEnTodos();
    }

    public String despedida() { return vista.despedida(); }
    public String opcionInvalida() { return vista.opcionInvalida(); }
}
