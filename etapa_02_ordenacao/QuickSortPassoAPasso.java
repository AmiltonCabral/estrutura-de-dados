package etapa_02_ordenacao;

import java.util.Scanner;

class QuickSortPassoAPasso {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] v = converteLista(input.nextLine().split(" "));
        quickSort(v);
        input.close();
    }


    public static void quickSort(int[] v) {
        quickSort(v, 0, v.length - 1);
    }


    private static void quickSort(int[] v, int left, int right) {
        if (left < right) {
            int pivot = partition(v, left, right);
            print(v);
            quickSort(v, left, pivot - 1);
            quickSort(v, pivot + 1, right);
        }
    }


    private static int partition(int v[], int left, int right) {
        int i = left;
        for (int j = i+1; j <= right; j++) {
            if (v[j] <= v[left]) {   // v[left] == pivot
                i++;
                swap(v, i, j);
            }
        }
        swap(v, left, i);
        return i;
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


    private static void print(int[] lista) {
        String output = "";
        for (int i=0; i<lista.length; i++) {
            output += lista[i];
            if (i < lista.length - 1)
                output += " ";
        }
        System.out.println(output);
    }
}