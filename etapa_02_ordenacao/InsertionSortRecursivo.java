package etapa_02_ordenacao;

import java.util.Arrays;
import java.util.Scanner;

class InsertionSortRecursivo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] v = converteLista(input.nextLine().split(" "));
        insertionSort(v);
        input.close();
    }


    private static void insertionSort(int[] v) {
    }


    private static int[] converteLista(String[] lista) {
        int[] novaLista = new int[lista.length];
        for (int i=0; i<lista.length; i++) {
            novaLista[i] = Integer.parseInt(lista[i]);
        }
        return novaLista;
    }
}