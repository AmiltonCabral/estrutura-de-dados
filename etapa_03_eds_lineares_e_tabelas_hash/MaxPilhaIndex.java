package etapa_03_eds_lineares_e_tabelas_hash;

import java.util.Scanner;
import java.util.Stack;

/**
 * MaxPilha
 */
class MaxPilhaIndex {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Integer> pilha = getPilha(input.nextLine().split(" "));
        System.out.println(getMaxPilha(pilha, input.nextInt()));
        input.close();
    }


    private static int getMaxPilha(Stack<Integer> pilha, int MaxIndex) {
        int maxValue = pilha.peek();
        Stack<Integer> auxPilha = new Stack<Integer>();
        int i = 0;
        while(!pilha.empty()) {
            if(pilha.peek() > maxValue && i<=MaxIndex) {
                maxValue = pilha.peek();
            }
            i++;
            auxPilha.push(pilha.pop());
        }
        while(!auxPilha.empty())
            pilha.push(auxPilha.pop());
        return maxValue;
    }


    private static Stack<Integer> getPilha(String[] seq) {
        Stack<Integer> pilha = new Stack<Integer>();
        for(String value : seq)
            pilha.push(Integer.parseInt(value));
        return pilha;
    }
}