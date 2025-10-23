import java.util.Scanner;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows for the pattern.");
        
        int n = sc.nextInt();

        System.out.println();
        System.out.println("Pattern :");
        System.out.println();

        for (int line = 0; line < n; line++) {
            int C = 1;  // c = curr line
            for (int i = 0; i < n - line - 1; i++) System.out.print(" ");
            for (int i = 0; i <= line; i++) {
                System.out.print(C + " ");
                C = C * (line - i) / (i + 1);
            }
            System.out.println();
        }
    }
}