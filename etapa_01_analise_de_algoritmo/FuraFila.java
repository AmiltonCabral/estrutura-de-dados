package etapa_01_analise_de_algoritmo;

import java.util.Arrays;
import java.util.Scanner;

class FuraFila {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] fila = input.nextLine().split(" ");
        int comeco = 0;

        for (int i=input.nextInt(); i<fila.length; i++) {
            String aux = fila[i];
            
            for (int j=i; j>comeco; j-=1) {
                fila[j] = fila[j-1];
                fila[j-1] = aux;
            }
            comeco++;
            
            System.out.println(Arrays.toString(fila));
        }
    }
}
