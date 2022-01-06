package etapa_02_ordenacao;

import java.util.Arrays;
import java.util.Scanner;

class SelectionSortPassoPasso {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] lista = converteLista(input.nextLine().split(" "));
		sort(lista);
		input.close();
	}


	public static void sort(int[] v) {
        for (int i = 0; i < v.length; i++) {
            int i_smaller = i;
            for (int j = i + 1; j < v.length; j++)
                if (v[j] < v[i_smaller])
                    i_smaller = j;

            swap(v, i, i_smaller);
            if (i != i_smaller)
                System.out.println(Arrays.toString(v));
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