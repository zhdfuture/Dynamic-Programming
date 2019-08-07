import java.util.Scanner;
/*
取模运算有这样一个性质：(a+b)%c = ((a%c)+(b%c))%c
所以(a[i-1]+a[i-2])%1000000007就相当于(a[i-1]%X+a[i-2]%X)%X   用X代替1000000007
这样就使得a[i-1]、a[i-2]、a[i-1]+a[i-2]都没有溢出，之后再与a[i-3]相加之后取模，使得全部结果没有溢出。
 */
public class UpStairs {
    public int countWays(int n) {
        // write code here
        int[] ret1 = {1,2,4};
        if (n <4) {
            return ret1[n-1];
        }
        for (int i = 4; i <= n; i++) {
            int temp = ((ret1[0]+ret1[1])%1000000007 + ret1[2])%1000000007;
            ret1[0] = ret1[1];
            ret1[1] = ret1[2];
            ret1[2] = temp;
        }
        int result = ret1[2];
        return result;

    }
    public static void main(String[] args) {
        UpStairs test=new UpStairs();
       Scanner scan=new Scanner(System.in);
       int n=scan.nextInt();
        System.out.println(test.countWays(n));
    }
}

