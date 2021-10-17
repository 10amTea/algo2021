package com.mark.twoweek.prefixadd;

/**
 * @author sun
 * @date 2021-10-17 16:11
 */
public class _2_LC_53 {
    // TODO 贪心同样可以做，双指针一旦出现负数贡献不要往后挪至j+1重新开始
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] s = new int[n + 1];
        int[] preMin = new int[n + 1];
        s[0] = 0;
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + nums[i - 1];
        }
        preMin[0] = 0;
        for (int i = 1; i <= n; i++) {
            preMin[i] = Math.min(preMin[i - 1], s[i]);
        }
        int ans = -100000;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, s[i] - preMin[i - 1]);
        }
        return ans;
    }
}
