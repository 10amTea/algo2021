package com.mark.oneweek.array;

/**
 * @author sun
 * @date 2021-10-07 9:16
 */
public class _1_LC_26 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int cnt = 0;
        // cnt是最终的个数，所以最后++不用处理
        // while写法
        while (i < nums.length) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[cnt] = nums[i];
                cnt++;
            }
            i++;
        }
        return cnt;
    }
}
