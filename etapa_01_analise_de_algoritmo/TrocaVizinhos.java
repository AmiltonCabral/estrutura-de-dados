import java.util.Arrays;
import java.util.Scanner;

class TrocaVizinhos {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] listNum = input.nextLine().split(" ");
        String[] newListNum = new String[listNum.length];

        for(int i=0; i<listNum.length; i+=2) {
            if (i < listNum.length - 1) {
                newListNum[i] = listNum[i+1];
                newListNum[i+1] = listNum[i];
            } else {
                newListNum[i] = listNum[i];
            }
        }

        System.out.println(Arrays.toString(newListNum));
    }
}