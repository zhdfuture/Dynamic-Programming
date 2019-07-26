import java.util.ArrayList;

/*
 给定一个三角矩阵，找出自顶向下的最短路径和，每一步可以移动到下一行的相邻数字
状态：
  子状态：从(n,n),(n,n-1),...(1,0),(1,1),(0,0)到最后一行的最短路径和
  F(i,j): 从(i,j)到最后一行的最短路径和
状态递推：
  F(i,j) = min( F(i+1, j), F(i+1, j+1)) + triangle[i][j]
初始值：
  F(n-1,0) = triangle[n-1][0], F(n-1,1) = triangle[n-1][1],..., F(n-1,n-1) = triangle[n-
1][n-1]
返回结果：
  F(0, 0)
 反向思维
 */
public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<triangle.get(i+1).size()-1;j++){
                int min=Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1));
                triangle.get(i).set(j,triangle.get(i).get(j)+min);
            }
        }
        return triangle.get(0).get(0);
    }
}
