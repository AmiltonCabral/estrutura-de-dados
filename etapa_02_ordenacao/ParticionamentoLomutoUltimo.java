package etapa_02_ordenacao;

import java.util.Arrays;
import java.util.Scanner;

class ParticionamentoLomutoUltimo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] v = converteLista(input.nextLine().split(" "));
        partitionUltimo(v, 0, v.length-1);
        System.out.println(Arrays.toString(v));
        input.close();
    }


    private static int partitionUltimo(int v[], int left, int right) {
        int pivot = v[right];
        int i = right;
        for (int j = i-1; j >= left; j--) {
            if (v[j] > pivot) {
                i--;
                swap(v, i, j);
            }
        }
        swap(v, right, i);
        return i;
    }


    private static void swap(int[] lista, int ind1, int ind2) {
        int aux = lista[ind1];
        lista[ind1] = lista[ind2];
        lista[ind2] = aux;
        System.out.println(Arrays.toString(lista));
    }

    
    private static int[] converteLista(String[] lista) {
        int[] novaLista = new int[lista.length];
        for (int i=0; i<lista.length; i++) {
            novaLista[i] = Integer.parseInt(lista[i]);
        }
        return novaLista;
    }

}