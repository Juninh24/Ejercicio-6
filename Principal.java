import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Controlador controlador = new Controlador();
        int opcion;

        do {
            System.out.println(controlador.mostrarMenu());
            opcion = leerEntero(sc, "Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    System.out.println(controlador.listar());
                    break;
                case 2:
                    int id = leerEntero(sc, "Ingrese el ID: ");
                    System.out.println(controlador.buscarPorId(id));
                    break;
                case 3:
                    System.out.print("Ingrese el nombre: ");
                    String nombre = sc.nextLine().trim();
                    System.out.println(controlador.buscarPorNombre(nombre));
                    break;
                case 4:
                    System.out.println(controlador.ordenarPorMemoria());
                    break;
                case 5:
                    System.out.println(controlador.renderizarTodos());
                    break;
                case 6:
                    System.out.println(controlador.clicEnTodos());
                    break;
                case 0:
                    System.out.println(controlador.despedida());
                    break;
                default:
                    System.out.println(controlador.opcionInvalida());
            }
        } while (opcion != 0);

        sc.close();
    }

    private static int leerEntero(Scanner sc, String mensaje) {
        int valor = 0;
        boolean valido = false;
        do {
            System.out.print(mensaje);
            try {
                valor = Integer.parseInt(sc.nextLine().trim());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número entero.");
            }
        } while (!valido);
        return valor;
    }
}
