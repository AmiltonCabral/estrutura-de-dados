package etapa_02_ordenacao;

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
        int countArrLength = (-1*m)+(k+1);
        int[] countArr = new int[countArrLength];
        for(int i=0; i<=k; i++) {
            countArr[i] = 0;
        }

        // Count the number of times that a number apear in the array
        for(int i=0; i<a.length; i++) {
            countArr[a[i]+(-1*m)]++;
            print(countArr);
        }

        // countArr will have the number of elements lower or equals to i.
        for(int i=1; i<countArrLength; i++) {
            countArr[i] = countArr[i] + countArr[i-1];
        }
        System.out.print("Cumulativa do vetor de contagem - ");
        print(countArr);

        // Create a auxiliar array that will be the original array ordered
        // Important traverse the array from right to left to keep stable
        int[] newArr = new int[a.length];
        for(int i=a.length - 1; i>=0; i--) {
            newArr[countArr[a[i] + (-1*m)] - 1] = a[i];
            countArr[a[i] + (-1*m)]--;
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