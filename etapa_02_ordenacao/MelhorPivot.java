package etapa_02_ordenacao;

import java.util.Scanner;

class MelhorPivot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] seq = converteLista(input.nextLine().split(" "));
        int i = input.nextInt();
        int j = input.nextInt();
        System.out.println(melhorPivot(seq, i, j));
        input.close();
    }


    private static int melhorPivot(int[] seq, int i, int j) {
        int countI = 0;
        int countJ = 0;

        for (int x = 0; x<seq.length; x++) {
            if (seq[x] < seq[i]) {
                countI++;
            } else if (seq[x] > seq[i])
                countI--;

            if (seq[x] < seq[j]) {
                countJ++;
            } else if (seq[x] > seq[j])
                countJ--;
        }

        if (Math.abs(countI) <= Math.abs(countJ))
            return i;
        return j;
    }   
    

    private static int[] converteLista(String[] lista) {
        int[] novaLista = new int[lista.length];
        for (int i=0; i<lista.length; i++) {
            novaLista[i] = Integer.parseInt(lista[i]);
        }
        return novaLista;
    }
}