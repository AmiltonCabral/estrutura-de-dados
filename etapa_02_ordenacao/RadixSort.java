package etapa_02_ordenacao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * RadixSort
 * 
 * - Considerar que todos os valores a serem ordenados tem a
 * mesma quantidade d de dígitos.
 * - Seu programa deve ler duas linhas da entrada padrão. A
 * primeira é uma sequência de inteiros separados por espaço
 * e a segunda um número inteiro d representando a quantidade
 * de dígitos dos elementos lidos.
 * 
 * TIP:
 * --- num = 1894 ---
 * unidade = num //    1 % 10 # 4
 * dezena  = num //   10 % 10 # 9 
 * centena = num //  100 % 10 # 8 
 * milhar  = num // 1000 % 10 # 1
 * 
 * # números com 0 (check)
 * # números com dígitos divergentes
 * # optional: negative numbers
 */
class RadixSort {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] seq = converteLista(input.nextLine().split(" "));
        int d = input.nextInt();
        radixSort(seq, d);
        input.close();
    }


    /**
     * 
     * @param a o array a ser ordenado.
     * @param d quantos dígitos cada número tem.
     * @return o array ordenado.
     */
    public static int[] radixSort(int[] a, int d) {
        for(int i=1; i<=d; i++) {
            a = countingSort(a, i);
            System.out.println(Arrays.toString(a));
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