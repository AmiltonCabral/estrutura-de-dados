package etapa_01_analise_de_algoritmo;

import java.util.Scanner;

class BuscaBinaria2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] seq = converteLista(input.nextLine().split(" "));
        int N = input.nextInt();
        buscaBinaria(seq, N);
        input.close();
    }


    public static int buscaBinaria(int[] seq, int N) {
        return buscaBinaria(seq, N, 0, seq.length - 1);
    }


    private static int buscaBinaria(int[] seq, int N, int left, int right) {
        int meio = (right + left) / 2;
        System.out.println(meio);
        if (seq[meio] == N)
            return seq[meio];

        if (left < right) 
            if (seq[meio] > N)
                return buscaBinaria(seq, N, left, meio - 1);
            else
                return buscaBinaria(seq, N, meio + 1, right);

        System.out.println(-1);
        return -1;
    }


    private static int[] converteLista(String[] lista) {
        int[] novaLista = new int[lista.length];
        for (int i=0; i<lista.length; i++)
            novaLista[i] = Integer.parseInt(lista[i]);
        return novaLista;
    }
}