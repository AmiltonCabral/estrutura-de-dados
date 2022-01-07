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


    /**
     * 
     * @param a the array to be ordered
     * @param k the maximum value of the array
     */
    private static void sort(int[] a, int k) {
        
        // Create auxiliary vector with zero values.
        int[] vAux = new int[k+1];
        for(int i=0; i<=k; i++) {
            vAux[i] = 0;
        }

        // *** Count the number of times that a number apear in the array
        for(int i=0; i<k; i++) {
            vAux[a[i]] = vAux[a[i]] + 1;
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