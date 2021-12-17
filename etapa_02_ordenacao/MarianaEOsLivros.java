package etapa_02_ordenacao;

import java.util.Scanner;

class MarianaEOsLivros {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] estante = input.nextLine().split(",");
        sort(estante);
    }


    private static void sort(String[] estante) {
        for (int i=1; i<estante.length; i++) {
            print(estante);
            int j = i;
    
            while (j > 0 && estante[j].compareTo(estante[j-1]) < 0) {
                swap(estante, j, j-1);
                j -= 1;
            }
    
        }
        print(estante);
    }


    private static void swap(String[] lista, int ind1, int ind2) {
        String aux = lista[ind1];
        lista[ind1] = lista[ind2];
        lista[ind2] = aux;
    }


    private static void print(String[] lista) {
        String output = "";
        for (int i=0; i<lista.length; i++) {
            output += lista[i];
            if (i < lista.length - 1)
                output += ", ";
        }
        System.out.println(output);
    }
}