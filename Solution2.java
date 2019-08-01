public class Solution2 {
    public int numDistinct(String S, String T) {
        int lengthS=S.length();
        int lengthT=T.length();
        if(S==null){
            if(T==null){
                return 1;
            }
            return 0;
        }
        if(T==null){
            return 1;
        }
        int[] nDis=new int[lengthT+1];
        nDis[0]=1;
        for(int i=1;i<=lengthS;i++){

            for(int j=lengthT;j>0;j--){
                if(S.charAt(i-1)==T.charAt(j-1)){
                    nDis[j]=nDis[j-1]+nDis[j];   //上一行的值，更新当前的值

                }

            }
        }
        return nDis[lengthT];
    }
}

