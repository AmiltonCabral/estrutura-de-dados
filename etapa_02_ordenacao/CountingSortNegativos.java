package etapa_02_ordenacao;

import java.util.Arrays;
import java.util.Scanner;

class CountingSortNegativos {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] seq = converteLista(input.nextLine().split(" "));
        int k = input.nextInt(); //max input
        int m = input.nextInt(); //min input
        sort(seq, k, m);
        input.close();
    }


    /**
     * 
     * @param a the array to be ordered
     * @param k the maximum value of the array
     * @param m the minimum value of the array
     */
    private static void sort(int[] a, int k, int m) {
        // Create auxiliary vector with zero values.
        // countArrLength = k-m+1;
        int[] countArr = new int[k-m+1];

        // Count the number of times that a number apear in the array
        for(int i=0; i<a.length; i++) {
            countArr[a[i] -m]++;
            System.out.println(Arrays.toString(countArr));
        }

        // countArr will have the number of elements lower or equals to i.
        for(int i=1; i<(k-m+1); i++) {
            countArr[i] += countArr[i-1];
        }
        System.out.print("Cumulativa do vetor de contagem - ");
        System.out.println(Arrays.toString(countArr));

        // Create a auxiliar array that will be the original array ordered
        int[] newArr = new int[a.length];
        // Important traverse the array from right to left to keep stable
        for(int i=a.length - 1; i>=0; i--) {
            newArr[countArr[a[i] -m] - 1] = a[i];
            countArr[a[i] -m]--;
        }
        System.out.println(Arrays.toString(countArr));

        // Copy the auxiliar array (ordered) to the original array
        // You can also return newArr and delete the lines below
        for(int i=0; i<a.length; i++) {
            a[i] = newArr[i];
        }
        System.out.println(Arrays.toString(a));
    }


    private static int[] converteLista(String[] lista) {
        int[] novaLista = new int[lista.length];
        for (int i=0; i<lista.length; i++) {
            novaLista[i] = Integer.parseInt(lista[i]);
        }
        return novaLista;
    }
}