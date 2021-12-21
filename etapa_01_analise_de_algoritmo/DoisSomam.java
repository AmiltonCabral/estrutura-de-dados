package etapa_01_analise_de_algoritmo;

import java.util.Scanner;

class DoisSomam {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] seqNum = input.nextLine().split(" ");
        int somaEsperada = input.nextInt();
        input.close();
        
        for (int i=0; i<seqNum.length; i++) {
            for (int j=i+1; j<seqNum.length; j++) {
                if (Integer.parseInt(seqNum[i]) + Integer.parseInt(seqNum[j]) == somaEsperada) {
                    System.out.println(seqNum[i] + " " + seqNum[j]);
                    return;
                }
            }
        }

        System.out.println(-1);
    }
}