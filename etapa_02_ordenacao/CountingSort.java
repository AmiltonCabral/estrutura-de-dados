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
        int[] countArr = new int[k+1];

        // Count the number of times that a number apear in the array
        for(int i=0; i<a.length; i++) {
            countArr[a[i]]++;
            print(countArr);
        }

        // countArr will have the number of elements lower or equals to i.
        for(int i=1; i<=k; i++) {
            countArr[i] = countArr[i] + countArr[i-1];
        }
        System.out.print("Cumulativa do vetor de contagem - ");
        print(countArr);

        // Create a auxiliar array that will be the original array ordered
        // Important tranverse the array from right to left to keep stable
        int[] newArr = new int[a.length];
        for(int i=a.length - 1; i>=0; i--) {
            newArr[countArr[a[i]] - 1] = a[i];
            countArr[a[i]]--;
        }
        print(countArr);

        // Copy the auxiliar array (ordered) to the original array
        for(int i=0; i<a.length; i++) {
            a[i] = newArr[i];
        }
        print(a);
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