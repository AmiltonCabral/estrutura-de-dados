package etapa_02_ordenacao;

import java.util.Scanner;

class EstatisticaDeOrdem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] seq = converteLista(input.nextLine().split(" "));
        System.out.println(partition(seq, 0, seq.length-1) + 1);
        input.close();
    }

    
    private static int partition(int v[], int left, int right) {
        int pivot = v[left];
        int i = left;
        for (int j = i+1; j <= right; j++) {
            if (v[j] < pivot) {
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
}