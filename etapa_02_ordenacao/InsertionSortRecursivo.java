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


    public static void insertionSort(int[] v) {
        insertionSort(v, 1);
    }


    private static void insertionSort(int[] v, int i) {
        if (i <= v.length-1) {
            int j = i;
            while (j > 0 && v[j] < v[j-1]) {
                swap(v, j, j-1);
                j--;
            }
            System.out.println(Arrays.toString(v));
            insertionSort(v, i+1);
        }
    }


    private static void swap(int[] lista, int ind1, int ind2) {
        int aux = lista[ind1];
        lista[ind1] = lista[ind2];
        lista[ind2] = aux;
    }


    private static int[] converteLista(String[] lista) {
        int[] novaLista = new int[lista.length];
        for (int i=0; i<lista.length; i++) {
            novaLista[i] = Integer.parseInt(lista[i]);
        }
        return novaLista;
    }
}