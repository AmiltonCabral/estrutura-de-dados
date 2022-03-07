package etapa_03_eds_lineares_e_tabelas_hash;

import java.util.HashMap;
import java.util.Scanner;

/**
 * WordCloud
 */
public class WordCloud {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap<String, Integer> freq = new HashMap<>();
        String[] frase = input.nextLine().split(" ");
        for(String palavra : frase) {
            if(freq.containsKey(palavra)) {
                freq.put(palavra, ((int) freq.get(palavra) + 1));
            } else {
                freq.put(palavra, 1);
            }
        }

        while (true) {
            String entry = input.nextLine();
            if (entry.equals("fim")) break;

            System.out.println(freq.get(entry));
        }

        input.close();
    }
}