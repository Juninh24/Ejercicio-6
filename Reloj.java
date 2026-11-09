import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Reloj extends Widget {
    private String zonaHoraria;

    public Reloj(int id, String nombre, int memoriaKB, String zonaHoraria) {
        super(id, nombre, memoriaKB);
        this.zonaHoraria = zonaHoraria;
    }

    public String getZonaHoraria() { return zonaHoraria; }
    public void setZonaHoraria(String zonaHoraria) { this.zonaHoraria = zonaHoraria; }

    @Override
    public String renderizar() {
        LocalTime hora = LocalTime.now(ZoneId.of(zonaHoraria));
        return "Reloj (" + zonaHoraria + "): " + hora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    @Override
    public String getConfiguracion() { return "Zona horaria: " + zonaHoraria; }
}
