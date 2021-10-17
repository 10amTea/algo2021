package com.mark.twoweek.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sun
 * @date 2021-10-16 16:09
 */
public class _1_LC_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(target - nums[i])) {
                return new int[]{indexMap.get(target - nums[i]), i};
            }
            indexMap.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        // TODO 数组初始化方式，hw blog中补全
        int[] array = {3, 3};
        new _1_LC_1().twoSum(array, 6);
    }
}
