package etapa_03_eds_lineares_e_tabelas_hash;

import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * InverteFrase
 * 
 * Inverter uma frase
 * Proibido usar método trim().
 */
class InverteFrase {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Deque<String> pilha = getPilha(input.nextLine());
        printPilha(pilha);
        input.close();
    }

    private static void printPilha(Deque<String> pilha) {
        String output = "";
        for(String word : pilha) {
            output += word + " ";
        }
        System.out.println(output.trim());
    }

    private static Deque<String> getPilha(String frase) {
        Deque<String> pilha = new ArrayDeque<String>();
        String word = "";
        for(int i=0; i<frase.length(); i++) {
            if(frase.charAt(i) != ' ') {
                word += frase.charAt(i);
                continue;
            }
            pilha.push(word);
            word = "";
        }
        pilha.push(word);
        
        return pilha;
    }
}