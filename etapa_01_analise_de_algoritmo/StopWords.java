package etapa_01_analise_de_algoritmo;

import java.util.Scanner;

class StopWords {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] phrase = input.nextLine().split(" ");
        String[] stpWords = input.nextLine().split(" ");
        String output = "";
        
        for (String phrWord : phrase) {
            boolean pass = true;
            for (String stpWord : stpWords) {
                if (phrWord.equals(stpWord)) {
                    pass = false;
                    break;
                }
            }
            if (pass) output += phrWord + " ";
        }

        System.out.println(output.trim());
        input.close();
    }
}