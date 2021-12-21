package etapa_01_analise_de_algoritmo;

import java.util.Scanner;

class VerificaDuplicado {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] seqNum = input.nextLine().split(" ");
        boolean result = false;
        
        for(int i=0; i<seqNum.length; i++) {
            if (result) break;
            for(int j=i+1; j<seqNum.length; j++) {
                if(seqNum[i].equals(seqNum[j])) {
                    result = true;
                    break;
                }
            }
        }
        
        System.out.println(result);
        input.close();
    }
}