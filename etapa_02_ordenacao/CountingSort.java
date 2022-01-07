package etapa_02_ordenacao;

import java.util.Scanner;

class CountingSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] seq = converteLista(input.nextLine().split(" "));
        int k = input.nextInt();
        sort(seq, k);
        input.close();
    }


    private static void sort(int[] v, int k) {

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