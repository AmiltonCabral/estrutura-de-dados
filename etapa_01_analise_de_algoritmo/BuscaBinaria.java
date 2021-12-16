import java.util.Scanner;

class BuscaBinaria {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] seqStr = input.nextLine().split(" ");
        int N = input.nextInt();
        int[] seq = converteLista(seqStr);
        buscaRecursiva(seq, N, 0, seq.length -1);
    }
    
    private static int buscaRecursiva(int[] seq, int N, int ini, int fim) {
        if (ini <= fim) {    
            int meio = (ini + fim) / 2;
            
            System.out.println(meio);
    
            if (seq[meio] == N) return meio;
    
            if (N < seq[meio])
                return buscaRecursiva(seq, N, ini, meio - 1);
            else
                return buscaRecursiva(seq, N, meio + 1, fim);
        } else {
            System.out.println(-1);
            return -1;
        }
    }

    private static int[] converteLista(String[] seqStr) {
        int[] seqInt = new int[seqStr.length];
        for (int i=0; i<seqStr.length; i++) {
            seqInt[i] = Integer.parseInt(seqStr[i]);
        }
        return seqInt;
    }
}
