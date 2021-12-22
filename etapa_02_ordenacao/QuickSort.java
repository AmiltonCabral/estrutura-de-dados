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
        
    }





    
    private static int[] converteLista(String[] lista) {
        int[] novaLista = new int[lista.length];
        for (int i=0; i<lista.length; i++) {
            novaLista[i] = Integer.parseInt(lista[i]);
        }
        return novaLista;
    }
}