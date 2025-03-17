package torreshanoi;

import java.util.Scanner;

public class TorresdeHanoi {


    public static void moverDiscos(int n, char origen, char destino, char auxiliar) {
        if (n == 1) {
            System.out.println("Mover disco de tamaño 1 de " + origen + " a " + destino);
        } else {
