package etapa_03_eds_lineares_e_tabelas_hash;

import java.util.Scanner;
import java.util.Stack;

/**
 * InvertePilha
 * 
 * Only use: pop, push and isEmpty on the Stack
 */
class InvertePilha {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        printStack(invertStack(mkStack(input)));
        input.close();
    }


    private static Stack<Integer> invertStack(Stack<Integer> stk) {
        Stack<Integer> auxStk = new Stack<Integer>();
        while(!stk.isEmpty()) {
            auxStk.push(stk.pop());
        }
        return auxStk;
    }


    private static Stack<Integer> mkStack(Scanner input) {
        Integer len = input.nextInt();
        Stack<Integer> stk = new Stack<Integer>();
        for(int i=0; i<len; i++)
            stk.push(input.nextInt());
        return stk;
    }


    private static void printStack(Stack<Integer> stk) {
        while(!stk.isEmpty()) {
            System.out.println(stk.pop());
        }
    }

}