package etapa_01_analise_de_algoritmo;

import java.util.Scanner;

/**
 * EncontraPrimeiroNegativo
 */
class EncontraPrimeiroNegativo {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] seq = converteLista(input.nextLine().split(" "));
        buscarNegativo(seq);
        input.close();
    }


    public static void buscarNegativo(int[] seq) {
        buscarNegativo(seq, 0);
    }


    private static void buscarNegativo(int[] seq, int i) {
        if(seq.length <= i) {
            System.out.println("-");
            return;
        }

        if(seq[i] < 0) {
            System.out.println(seq[i]);
            return;
        }

        buscarNegativo(seq, i+1);
    }


    private static int[] converteLista(String[] lista) {
        int[] novaLista = new int[lista.length];
        for (int i=0; i<lista.length; i++) {
            novaLista[i] = Integer.parseInt(lista[i]);
        }
        return novaLista;
    }
}