import java.util.ArrayList;

public class Vista {

    public String menu() {
        return "\n===== DASHBOARD DE WIDGETS =====\n"
             + "1. Listar widgets activos\n"
             + "2. Buscar widget por ID\n"
             + "3. Buscar widget por nombre\n"
             + "4. Ordenar por memoria (KB)\n"
             + "5. Renderizar todos los widgets\n"
             + "6. Simular clic en todos los widgets\n"
             + "0. Salir";
    }

    public String lista(ArrayList<Widget> widgets) {
        String texto = "--- Widgets (" + widgets.size() + ") ---\n";
        for (Widget w : widgets) {
            texto += w + "\n";
        }
        return texto;
    }

    public String detalle(Widget w) {
        return w + "\n   Configuración: " + w.getConfiguracion();
    }

    public String noEncontrado(String criterio) {
        return "No se encontró ningún widget con " + criterio + ".";
    }

    public String titulo(String texto) {
        return "--- " + texto + " ---\n";
    }

    public String despedida() { return "Hasta luego."; }
    public String opcionInvalida() { return "Opción inválida."; }
}
