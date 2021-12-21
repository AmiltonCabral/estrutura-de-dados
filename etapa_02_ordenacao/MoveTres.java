package etapa_02_ordenacao;

import java.util.Arrays;
import java.util.Scanner;

class MoveTres {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] lista = converteLista(input.nextLine().split(" "));
        sort(lista);
        input.close();
    }


    private static void sort(int[] lista) {
        for (int i=1; i<lista.length; i+= 1) {
            if (lista[i] < lista[i-1]) {
                int j = i;
                int n = 0;

                while (j>0 && n<3) {
                    if (lista[j] < lista[j-1]) {
                        swap(lista, j, j-1);
                        j--;
                        System.out.println(Arrays.toString(lista));
                    }
                    if (j==0 || lista[j] >= lista[j-1]) {
                        n++;
                        j = i + n;
                    }
                }
            }
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
}