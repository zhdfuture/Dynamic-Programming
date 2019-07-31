/*
1.回文串：正读和反读都一样的字符串，比如noon，level，字符串左右对称
题目描述：
  给定一个字符串 s,把 s 分割成一系列的子串，分割的每一个子串都为回文串
  返回最小的分割次数
  比如，给定 s = "aab",
  返回1，因为一次分割就可以产生回文分割["aa","b"]
  a:0
 aa:0
 aab:aa b(或a  ab):1
方法：动态规划（方法一：）
状态：
  子状态：到第1,2,3,...,n个字符需要的最小分割数
  F(i): 到第i个字符需要的最小分割数
状态递推：
  F(i) = min{F(i), 1 + F(j)}, { j<i && j+1到i是回文串}      分成了1~j  j+1~i   ,在此基础上再分割一次，保证都为回文串

  上式表示如果从j+1到i判断为回文字符串，且已经知道从第1个字符
  到第j个字符的最小切割数，那么只需要再切一次，就可以保证
  1-->j, j+1-->i都为回文串。
初始化：
  F(i) = i - 1： 表示到第i个字符需要的最大分割数
  比如单个字符只需要切0次，因为单子符都为回文串
  2个字符最大需要1次，3个2次......
返回结果：
  F(n)
 */
public class Palindrome {
    public int minCut(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        //F（i）=i-1;
        int[] cut=new int[s.length()+1];
        for(int i=0;i<=s.length();i++){
            cut[i]=i-1;
        }
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                //substring(j+1,i): min(F(j)+1,F(i))
                if(isPail(s,j,i-1)){
                    cut[i]=Math.min(cut[j]+1,cut[i]);
                }
            }
        }
        return cut[s.length()];
    }
    public boolean isPail(String s,int startIndex,int endIndex){
        while(startIndex<endIndex){
            if(s.charAt(startIndex)!=s.charAt(endIndex)){
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }
}


