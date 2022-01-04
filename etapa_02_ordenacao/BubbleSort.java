package etapa_02_ordenacao;

import java.util.Scanner;

class BubbleSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] v = converteLista(input.nextLine().split(" "));
        bubbleSort(v);
        input.close();
    }


    public static void bubbleSort(int[] v) {
        int N = v.length;
        boolean printed = false;
        for (int loop=1; loop<v.length; loop++) {
            boolean swapped = false;
            for (int i=0; i<N-1; i++) {
                if (v[i] > v[i+1]) {
                    swap(v, i, i+1);
                    swapped = true;
                }
            }
            if (!swapped) break;
            print(v);
            printed = true;
            N--;
        }
        if (!printed) print(v);
    }


    private static void swap(int[] lista, int ind1, int ind2) {
        int aux = lista[ind1];
        lista[ind1] = lista[ind2];
        lista[ind2] = aux;
    }


    private static void print(int[] lista) {
        String output = "";
        for (int i=0; i<lista.length; i++) {
            output += lista[i];
            if (i < lista.length - 1)
                output += " ";
        }
        System.out.println(output);
    }


    private static int[] converteLista(String[] lista) {
        int[] novaLista = new int[lista.length];
        for (int i=0; i<lista.length; i++) {
            novaLista[i] = Integer.parseInt(lista[i]);
        }
        return novaLista;
    }
}
