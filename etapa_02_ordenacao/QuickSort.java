package etapa_02_ordenacao;

import java.util.Arrays;
import java.util.Scanner;

class QuickSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] v = converteLista(input.nextLine().split(" "));
        quickSort(v);
        System.out.println(Arrays.toString(v));
        input.close();
    }


    public static void quickSort(int[] v) {
        quickSort(v, 0, v.length - 1);
    }


    private static void quickSort(int[] v, int left, int right) {
        if (left < right) {
            int pivot = partition(v, left, right);
            quickSort(v, left, pivot - 1);
            quickSort(v, pivot + 1, right);
        }
    }


    private static int partition(int v[], int left, int right) {
        // Select the median between 3 index to be pivot
        swap(v, left, pickPivotIndex(v, left, right));
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


    private static int pickPivotIndex(int v[], int left, int right) {
        int middle = (left + right) / 2;
        int[] sorted = {v[left], v[middle], v[right]};
        Arrays.sort(sorted);
        
        if (sorted[1] == v[left])
            return left;
        else if (sorted[1] == v[middle])
            return middle;
        else
            return right;
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