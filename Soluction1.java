
/*
HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式
识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是
否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0
个开始,到第3个为止)

状态：
  子状态：长度为1，2，3，...,n的子数组和的最大值
  F(i):长度为i的子数组和的最大值，这种定义不能形成递推关系，舍弃
  F(i):以array[i]为末尾元素的子数组和的最大值
状态递推：
  F(i) = max(F(i-1) + array[i]，array[i])
  F(i) = （F(i-1) > 0）? F(i-1) + array[i] : array[i]
初始值：F(0) = array[0]
返回结果：
  maxsum：所有F(i)中的最大值
 */
public class Soluction1 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array==null){
            return 0;
        }
        int maxsum=array[0];
        int curSum=array[0];
        for(int i=1;i<array.length;i++){
            curSum=(curSum>0)?curSum+array[i]:array[i];
            maxsum=(curSum<maxsum)?maxsum:curSum;
        }
        return maxsum;
    }

}
