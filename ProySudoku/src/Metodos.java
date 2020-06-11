
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
public class Metodos {
    public int[][] aleatorio(int matriz[][]) {
        Random ran = new Random();
        int cont = 0;
        int num = 0;
        int i = 0;
        int j = 0;
        boolean validar = false;
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[0].length; c++) {
                num = (ran.nextInt(4) + 1);
                if (matriz[f][c] == 0) {
                    validar = validarfc(matriz, num, f, c);
                    if (validar == true) {
                        validar = validarc(matriz, num, f, c);
                        if (validar == true) {
                            matriz[f][c] = num;
                        } else {
                            c -= 1;
                        }
                    } else {
                        c -= 1;
                    }
                } else {
                    c -= 1;
                }
            }
        }
        while (cont < 8) {
            i = ran.nextInt(4);
            j = ran.nextInt(4);
            if (matriz[i][j] != 0) {
                matriz[i][j] = 0;
                cont++;
            }
        }
       
        return matriz;
    }

    public void matriz(int matriz[][]) {
        for (int i = 0; i < 4; i++) {
            if (i == 2) {
                System.out.println();
            }
            for (int j = 0; j < 4; j++) {
                System.out.print(matriz[i][j] + "  ");
                if (j == 1) {
                    System.out.print("  ");
                }

            }
            System.out.println();
        }
        System.out.println("");
    }

    public boolean validarfc(int matriz[][], int num, int fila, int columna) {
        boolean v = false;
        int cont = 0;
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[fila][i] == num) {
                cont++;
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][columna] == num) {
                cont++;
            }
        }
        if (cont == 0) {
            v = true;
        }
        return v;
    }

    public boolean validarc(int matriz[][], int num, int fila, int columna) {
        boolean v = false;
        int cont = 0;
        if ((fila == 0 || fila == 1) && (columna == 0 || columna == 1)) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (matriz[i][j] == num) {
                        cont++;
                    }
                }
            }
        }
        if ((fila == 2 || fila == 3) && (columna == 0 || columna == 1)) {
            for (int i = 2; i < 4; i++) {
                for (int j = 0; j < 2; j++) {
                    if (matriz[i][j] == num) {
                        cont++;
                    }
                }
            }
        }
        if ((fila == 0 || fila == 1) && (columna == 2 || columna == 3)) {
            for (int i = 0; i < 2; i++) {
                for (int j = 2; j < 4; j++) {
                    if (matriz[i][j] == num) {
                        cont++;
                    }
                }
            }
        }
        if ((fila == 2 || fila == 3) && (columna == 2 || columna == 3)) {
            for (int i = 2; i < 4; i++) {
                for (int j = 2; j < 4; j++) {
                    if (matriz[i][j] == num) {
                        cont++;
                    }
                }
            }
        }
        if (cont == 0) {
            v = true;
        }
        return v;
    }

    public boolean fin(int matriz[][]) {
        boolean v = false;
        int cont = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 0) {
                    cont++;
                }
            }
        }
        if (cont == 0) {
            v = true;
        }
        return v;
    }
    
}
