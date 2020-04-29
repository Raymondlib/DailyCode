package leetcode1000.dp;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 俄罗斯套娃信封问题，二维套娃
 * 排序一维，然后求 第二维的 最长上升子序列
 * java 快速 偏序
 * 最长上升子序列
 *      两种做法
 *      n^2的 dp，每次更新
 *
 */
public class t354 {
    public static int lengthOfLIS2(int [] nums){
        int [] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j] <nums[i])
                dp[i] = Math.max(dp[i],dp[j]+1);
            }
        }
        int r = dp[0];
        for(int i=1;i<nums.length;i++){
            r= Math.max(r,dp[i]);
        }
        return r;
    }
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public static int maxEnvelopes(int[][] envelopes) {
//        Arrays.sort(envelopes, new Comparator<int[]>() {
//            public int compare(int[] arr1, int[] arr2) {
//                if (arr1[0] == arr2[0]) {
//                    return arr2[1] - arr1[1]; // 因为必须大于才能嵌套，所以 一维相等时，二维要逆序
//                } else {
//                    return arr1[0] - arr2[0];
//                }
//            }
//        });
        // 如果不用ide，怎么快速写出二维偏序
//        Arrays.sort(envelopes, (o1, o2)
//                -> o1[0] - o2[0] != 0 ? o1[0] - o2[0] : o2[1] - o1[1]);
        Arrays.sort(envelopes, (a, b)
                -> a[0] - b[0] != 0 ? a[0] - b[0] : a[1] - b[1]);
        System.out.println(Arrays.deepToString(envelopes));
        // extract the second dimension and run LIS
        int[] secondDim = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; ++i) secondDim[i] = envelopes[i][1];
        return lengthOfLIS2(secondDim);
    }

    public static void main(String[] args) {
        int [][] test= new int [][]{{5,4},{6,4},{6,7},{2,3}};
        System.out.println(maxEnvelopes(test));

    }
}
