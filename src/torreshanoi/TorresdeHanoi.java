package torreshanoi;
import java.util.Scanner;
import java.util.Stack;

public class TorresdeHanoi {

    // Representación de los postes como pilas (stacks)
    static Stack<Integer> posteA = new Stack<>();
    static Stack<Integer> posteB = new Stack<>();
    static Stack<Integer> posteC = new Stack<>();

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
            // Inicializar el poste A con los discos
            for (int i = numeroDeDiscos; i >= 1; i--) {
                posteA.push(i);
            }

            // Mostrar el estado inicial de los postes
            System.out.println("Estado inicial de los postes:");
            visualizarPostes();

            // Llamar a la función que resuelve la Torre de Hanoi
            System.out.println("Resolviendo la Torre de Hanoi con " + numeroDeDiscos + " discos:");
            moverDiscos(numeroDeDiscos, 'A', 'C', 'B'); // 'A' es el poste origen, 'C' es el poste destino, 'B' es el poste auxiliar
        }

        // Cerrar el scanner para liberar recursos
        scanner.close();
    }
    // Método recursivo para mover discos
    public static void moverDiscos(int n, char origen, char destino, char auxiliar) {
        if (n == 1) {
            // Mover el disco directamente al destino
            moverDisco(origen, destino);
        } else {
            // Mover n-1 discos del origen al auxiliar, usando el destino como apoyo
            moverDiscos(n - 1, origen, auxiliar, destino);

            // Mover el disco más grande (n) del origen al destino
            moverDisco(origen, destino);

            // Mover los n-1 discos del auxiliar al destino, usando el origen como apoyo
            moverDiscos(n - 1, auxiliar, destino, origen);
        }
    }
    // Método para mover un disco de un poste a otro
    public static void moverDisco(char origen, char destino) {
        int disco;

        // Sacar el disco del poste origen
        if (origen == 'A') {
            disco = posteA.pop();
        } else if (origen == 'B') {
            disco = posteB.pop();
        } else {
            disco = posteC.pop();
        }

        // Colocar el disco en el poste destino
        if (destino == 'A') {
            posteA.push(disco);
        } else if (destino == 'B') {
            posteB.push(disco);
        } else {
            posteC.push(disco);
        }

        // Mostrar el movimiento y el estado actual de los postes
        System.out.println("Mover disco de tamaño " + disco + " de " + origen + " a " + destino);
        visualizarPostes();
    }

    // Método para visualizar el estado actual de los postes
    public static void visualizarPostes() {
        System.out.println("Estado de los postes:");
        System.out.println("  Poste A: " + posteA);
        System.out.println("  Poste B: " + posteB);
        System.out.println("  Poste C: " + posteC);
        System.out.println("-----------------------------");
    }

}