package etapa_02_ordenacao;

import java.util.Arrays;
import java.util.Scanner;

class MergeSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] v = converteLista(input.nextLine().split(" "));
        mergeSort(v);
        System.out.println(Arrays.toString(v));
        input.close();
    }


    public static void mergeSort(int v[]) {
        mergeSort(v, 0, v.length - 1);
    }


    private static void mergeSort(int v[], int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(v, left, middle);
            mergeSort(v, middle + 1, right);
            merge(v, left, middle, right);
        }
    }


    private static void merge(int v[], int left, int middle, int right) {
        int[] helper = new int[v.length];
        for (int i=0; i<v.length; i++)
            helper[i] = v[i];

        int a = left;
        int b = middle + 1;
        int k = left;

        while (a <= middle && b <= right) {
            if (helper[a] <= helper[b])
                v[k++] = helper[a++];
            else 
                v[k++] = helper[b++];
        }

        while (a <= middle)
            v[k++] = helper[a++];

        while (b <= right)
            v[k++] = helper[b++];

    }


    private static int[] converteLista(String[] lista) {
        int[] novaLista = new int[lista.length];
        for (int i=0; i<lista.length; i++) {
            novaLista[i] = Integer.parseInt(lista[i]);
        }
        return novaLista;
    }
}


// 7 12 10 8 19 5 3 90