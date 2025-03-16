package hanoi;
import java.util.Scanner;


public class TorresDeHanoi {

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese el número de discos
        System.out.print("Ingrese el número de discos: ");
        int numeroDeDiscos = scanner.nextInt();

        // Validar que el número de discos sea mayor que 0
        if (numeroDeDiscos <= 0) {
            System.out.println("El número de discos debe ser mayor que 0.");
        } else {
            // Llamar a la función que resuelve la Torre de Hanoi
            System.out.println("Resolviendo la Torre de Hanoi con " + numeroDeDiscos + " discos:");
            moverDiscos(numeroDeDiscos, 'A', 'C', 'B'); // 'A' es el poste origen, 'C' es el poste destino, 'B' es el poste auxiliar
        }

        // Cerrar el scanner para liberar recursos
        scanner.close();
    }
}