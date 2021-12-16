import java.util.Scanner;

class TeoremaMeste {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int ord = input.nextInt();
        double log = Math.log(a) / Math.log(b);
        
        if (log < ord) {
            System.out.println("T(n) = theta(n**" + ord + ")");
        } else if (log == ord) {
            System.out.println("T(n) = theta(n**" + (int) log + " * log n)");
        }
    }
}
