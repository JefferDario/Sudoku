
import java.util.Scanner;
import java.util.Random;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Principal {
     public static void main(String[] args) {
        Metodos m = new Metodos();
        Scanner entrada = new Scanner(System.in);
        int fila = 0;
        int columna = 0;
        int num = 0;
        boolean fin = false;

        int[][] matriz = new int[4][4];
        boolean v = false;
        int cont = 0;
        matriz = m.aleatorio(matriz);
        m.matriz(matriz);
        
        
        do {
            do {
                System.out.println("Ingrese la fila");
                fila = (entrada.nextInt());
                if (fila >= 4 || fila < 0) {
                    System.out.println("El numero ingresado es mayor a 4 o menor a 1");
                }
            } while (fila < 0 || fila >= 4);
            do {
                System.out.println("Ingrese el numero de la columna");
                columna = (entrada.nextInt());
                if (columna >= 4 || columna < 0) {
                    System.out.println("El numero ingresado es mayor a 4 o menor a 1");
                }
            } while (columna < 0 || columna >= 4);
            if (matriz[fila][columna] == 0) {
                do {
                    System.out.println("Ingrese el valor");
                    num = entrada.nextInt();
                    if (num > 0 && num < 5) {
                        v = m.validarfc(matriz, num, fila, columna);
                        if (v == true) {
                            v = m.validarc(matriz, num, fila, columna);
                            if (v == true) {
                                matriz[fila][columna] = num;
                            } else {
                                System.out.println("El valor ingresado existe en el cuadrante");
                                num = 5;
                                cont++;
                            }
                        } else {
                            System.out.println("El valor ingresado no es válido");
                            num = 5;
                            cont++;
                        }
                    } else {
                        System.out.println("El número no es permitido");
                        cont++;
                    }
                    if (cont < 8) {
                    } else {
                        System.out.println("perdio");
                        System.exit(0);
                    }
                } while (num < 0 || num > 5);
            } else {
                System.out.println("Esa posición está ocupada");
            }
            m.matriz(matriz);
            fin = m.fin(matriz);
        } while (fin == false);
        System.out.println("Juego terminado");
    }
    
}
