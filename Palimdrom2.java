/*
方法二
 */
public class Palimdrom2 {
    public int minCut(String s) {
        if (s == null) {
            return 0;
        }
        int[] cut = new int[s.length() + 1];
        boolean[][] isPail = isPailn(s);
        for (int i = 0; i <= s.length(); i++) {
            cut[i] = i - 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // F(i) = min{F(i), 1 + F(j)}, where j<i && j+1到i是回文串
                // 从最长串判断，如果从第j+1到i为回文字符串
                // 则再加一次分割，从1到j，j+1到i的字符就全部分成了回文字符串
                if (isPail[j][i - 1]) {
                    cut[i] = Math.min(cut[i], 1 + cut[j]);

                }
            }
        }
        return cut[s.length()];
    }

    boolean[][] isPailn(String str) {
        boolean[][] mat = new boolean[str.length()][str.length()];
        for (int i = str.length() - 1; i >= 0; i--) {
            for (int j = i; j < str.length(); j++) {
                if (j == i) {
                    //单字符为回文字符串
                    mat[i][j] = true;
                } else if (j == i + 1) {
                    //相邻字符若相同 ，则为回文字符串
                    mat[i][j] = (str.charAt(i) == str.charAt(j));
                } else {
                    mat[i][j] = (str.charAt(i) == str.charAt(j)) && mat[i + 1][j - 1];
                }
            }
        }
        return mat;
    }
}
