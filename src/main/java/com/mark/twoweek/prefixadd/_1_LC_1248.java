package com.mark.twoweek.prefixadd;

/**
 * @author sun
 * @date 2021-10-17 11:24
 */
public class _1_LC_1248 {
    // 1、问题转换-》子段和-》前缀和
    // prefixAdd中存储的数组奇数的个数，偶数%2=0
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] prefixAdd = new int[n + 1];
        prefixAdd[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefixAdd[i] = prefixAdd[i - 1] + nums[i - 1] % 2;
        }

        // 两数之差，可以使用数组也可使用map
        int[] count = new int[n + 1];
        count[prefixAdd[0]]++; // prefixAdd[0]==0同样需要在count数组中计数，代表没有奇数出现
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (prefixAdd[i] - k >= 0) {
                ans += count[prefixAdd[i] - k];
            }
            // 对应前缀和位置出现值加+1
            count[prefixAdd[i]]++; // TODO 没有理解出来
        }
        return ans;
    }

    public static void main(String[] args) {
        new _1_LC_1248().numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3);
    }
}
