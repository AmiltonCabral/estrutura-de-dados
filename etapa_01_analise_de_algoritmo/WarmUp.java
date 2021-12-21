package etapa_01_analise_de_algoritmo;

import java.util.Scanner;

class WarmUp {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        String[] seqNum = input.nextLine().split(" ");
        String output = "";

        for (int i=0; i<seqNum.length; i++)
            output += Integer.parseInt(seqNum[i]) * n + " ";

        System.out.println(output.trim());
        input.close();
    }
}