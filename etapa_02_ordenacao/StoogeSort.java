package etapa_02_ordenacao;

import java.util.Scanner;

class StoogeSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] v = converteLista(input.nextLine().split(" "));
        stoogeSort(v);
        print(v);
        input.close();
    }


    public static void stoogeSort(int[] v) {
        stoogeSort(v, 0, v.length-1);
    }


    private static void stoogeSort(int[] v, int left, int right) {
        if (v[left] > v[right])
            swap(v, left, right);

        if (left + 1 < right) { //If array has 3 or more values
            int third = (right - left + 1) / 3;
            stoogeSort(v, left, right-third); //First third
            stoogeSort(v, left+third, right); //Last third
            stoogeSort(v, left, right-third); //First third
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