import java.util.Scanner;

/*
最大回文子串是被研究得比较多的一个经典问题。最近月神想到了一个变种，对于一个字符串，如果不要求子串连续，那么一个字符串的最大回文子串的最大长度是多少呢。
输入描述:
每个测试用例输入一行字符串（由数字0-9，字母a-z、A-Z构成），字条串长度大于0且不大于1000.
输出描述:
输出该字符串的最长回文子串的长度。（不要求输出最长回文串，并且子串不要求连续）
 */
public class FeiLianxuHuiWen {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        String str=scan.next();
        int[][] array=new int[str.length()+1][str.length()+1];
        array[0][0]=0;
        for(int i=1;i<=str.length();i++){
            array[i][i]=1;
        }
        for(int j=1;j<=str.length();j++){
            for(int i=1;i<j;i++){
                array[i][j]=array[i][j-1];
                for(int k=i;k<j;k++){
                    if(str.charAt(k-1)==str.charAt(j-1)){
                        array[i][j]=Math.max(array[i][j-1],array[k+1][j-1]+2);
                        break;
                    }
                }
            }
        }
        System.out.println(array[1][str.length()]);
    }
}


