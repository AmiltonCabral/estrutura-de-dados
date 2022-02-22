package etapa_03_eds_lineares_e_tabelas_hash;

import java.util.Scanner;
import java.util.Stack;

/**
 * ElementAtPilha
 */
class ElementAtPilha {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<String> stk = mkStack(input.nextLine().split(" "));
        printAtIndex(stk, input.nextInt());
        input.close();
    }


    private static void printAtIndex(Stack<String> stk, int index) {
        Stack<String> auxStk = new Stack<String>();
        while(!stk.isEmpty())
            auxStk.push(stk.pop());
        
        String output = "indice invalido";
        int i = 0;
        while(!auxStk.isEmpty()) {
            if(i == index)
                output = auxStk.peek();
            i++;
            stk.push(auxStk.pop());
        }

        System.out.println(output);
    }

    
    private static Stack<String> mkStack(String[] seq) {
        Stack<String> stk = new Stack<String>();
        for(String num : seq)
            stk.push(num);
        return stk;
    }
}