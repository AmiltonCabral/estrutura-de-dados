package etapa_03_eds_lineares_e_tabelas_hash;

import java.util.Scanner;
import java.util.Stack;

/**
 * Parenteses
 */
class Parenteses {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String seq = input.nextLine();
        System.out.println(isMathValid(seq));
        input.close();
    }
    

    private static String isMathValid(String seq) {
        Stack<Character> stk = new Stack<Character>();
        for(int i=0; i<seq.length(); i++) {
            if(seq.charAt(i) == '(') {
                stk.push('(');
            }
            else if(seq.charAt(i) == ')') {
                if(stk.isEmpty())
                    return "N";
                stk.pop();
            }
        }
        if(stk.isEmpty())
            return "S";
        return "N";
    }
}