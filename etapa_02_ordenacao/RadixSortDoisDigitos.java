package etapa_02_ordenacao;

import java.util.Arrays;
import java.util.Scanner;


class RadixSortDoisDigitos {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] seq = converteLista(input.nextLine().split(" "));
        int d = input.nextInt();
        radixSort(seq, d);
        input.close();
    }


    public static int[] radixSort(int[] a, int d) {
        //System.out.println(Arrays.toString(a));
        for(int i=1; i<=d; i++) {
            a = countingSort(a, i);
            if (i % 2 == 0) {
                System.out.println(Arrays.toString(a));
            }
        }

        return a;
    }


    private static int[] countingSort(int[] a, int nDig) {
        int dig = ((int) Math.pow(10, nDig)) / 10;

        // count array
        int[] countArr = new int[10];
        for(int i=0; i<a.length; i++) {
            countArr[(a[i] / dig % 10)]++;
        }

        // cumulative
        for(int i=1; i<10; i++) {
            countArr[i] += countArr[i-1];
        }

        // sort the new array
        int[] newArr = new int[a.length];
        for(int i=a.length -1; i>=0; i--) {
            newArr[countArr[(a[i] / dig % 10)] -1] = a[i];
            countArr[(a[i] / dig % 10)]--;
        }

        return newArr;
    }


    private static int[] converteLista(String[] lista) {
        int[] novaLista = new int[lista.length];
        for (int i=0; i<lista.length; i++) {
            novaLista[i] = Integer.parseInt(lista[i]);
        }

        return novaLista;
    }
}