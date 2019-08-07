import java.util.Scanner;

public class ShouXingShu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            String str=n+"";
            String str1 = String.valueOf(n * n);
            str1 = str1.substring(str1.length() - str.length());
            if (n == Integer.valueOf(str1)) {
                System.out.println();
                System.out.println("Yes!");
            } else {
                System.out.println("No!");

            }
        }
    }
}
