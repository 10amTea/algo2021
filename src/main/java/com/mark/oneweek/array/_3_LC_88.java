package com.mark.oneweek.array;

/**
 * @author sun
 * @date 2021-10-07 9:50
 */
public class _3_LC_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 从头会被覆盖，从尾部0位置开始
        int index = m + n - 1;
        int i = m - 1; // nums1
        int j = n - 1; // nums2
        while (index >= 0) {
            if (j < 0 || (i >= 0 && nums1[i] >= nums2[j])) { // j出界或者ij均没有出界要大的数
                nums1[index] = nums1[i];
                i--;
            } else {
                nums1[index] = nums2[j];
                j--;
            }
            index--;
        }
    }
}
