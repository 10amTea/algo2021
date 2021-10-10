package com.mark.oneweek.array;

/**
 * @author sun
 * @date 2021-10-07 9:42
 */
public class _2_LC_283 {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int cnt = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                nums[cnt] = nums[i];
                cnt++;
            }
            i++;
        }
        while (cnt < nums.length) {
            nums[cnt] = 0;
            cnt++;
        }
    }
}
