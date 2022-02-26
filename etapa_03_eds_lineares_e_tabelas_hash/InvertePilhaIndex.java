package etapa_03_eds_lineares_e_tabelas_hash;

import java.util.Scanner;
import java.util.Stack;

/**
 * InvertePilhaIndex
 * 
 * Only use: pop, push and isEmpty on the Stack
 */
class InvertePilhaIndex {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        printStack(invertStack(mkStack(input), input.nextInt()));
        input.close();
    }


    private static Stack<Integer> invertStack(Stack<Integer> stk, int index) {
        Stack<Integer> invStk = new Stack<Integer>();
        Stack<Integer> outStk = new Stack<Integer>();
        for(int i=0; i<=index; i++) {
            invStk.push(stk.pop());
        }
        while(!invStk.isEmpty()) {
            outStk.push(invStk.pop());
        }
        while(!stk.isEmpty()) {
            outStk.push(stk.pop());
        }
        while(!outStk.isEmpty()) {
            stk.push((outStk.pop()));
        }

        return stk;
    }


    private static Stack<Integer> mkStack(Scanner input) {
        Integer len = input.nextInt();
        Stack<Integer> stk = new Stack<Integer>();
        for(int i=0; i<len; i++)
            stk.push(input.nextInt());
        return stk;
    }


    private static void printStack(Stack<Integer> stk) {
        System.out.println("-");
        Stack<Integer> auxStk = new Stack<Integer>();
        while(!stk.isEmpty()) {
            auxStk.push(stk.peek());
            System.out.println(stk.pop());
        }
        while(!auxStk.isEmpty()){
            stk.push(auxStk.pop());
        }
    }

}