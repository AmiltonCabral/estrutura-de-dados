package etapa_01_analise_de_algoritmo;

import java.util.Scanner;

class VetorCircular {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] seqNum = input.nextLine().split(" ");
        int N = input.nextInt();
        String output = "";

        for(int i=0; i<N; i++)
            output += seqNum[i % seqNum.length] + " ";

        System.out.println(output.trim());
    }
}

/*

c1 -> atribuição input
c2 -> split do input N
c3 -> atribuição seqNum
c4 -> atribuição N
c5 -> atribuição output
cl1 -> atribuição i=0

cl2 -> (n+1)* expressão booleana i<N
cl3 -> (n)* operação aritmética i++

n* :
    c6 -> operação mat i % seqNum
    c7 -> operação mat X + " "
    c8 -> operação mat output + novo result
    c9 -> atribuição output = result 

f(n) = 6c + (n+1)*c + n*5c
*/