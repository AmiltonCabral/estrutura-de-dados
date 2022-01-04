package etapa_02_ordenacao;

import java.util.Scanner;

class DownN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] seq = converteLista(input.nextLine().split(" "));
        int n = input.nextInt();
        print(getTopN(seq, n));
        input.close();
    }


    private static int[] getTopN(int[] seq, int n) {
        int[] top = new int[n];
        for (int i=0; i<n; i++) {
            top[i] = Integer.MAX_VALUE;
            for (int j=0; j<seq.length; j++) {
                if (seq[j] < top[i] && !tem(top, seq, seq[j])) {
                    top[i] = seq[j];
                }
            }
        }
        return top;
    }


    private static boolean tem(int[] seq, int[] oldSeq, int n) {
        int countOS = 0;
        int countNS = 0;
        for (int i=0; i<oldSeq.length; i++) {
            if (oldSeq[i] == n)
                countOS++;   
        }
        for (int i=0; i<seq.length; i++) {
            if (seq[i] == n) {
                countNS++;
                if (countNS >= countOS)
                    return true;
            }
        }
        return false;
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
