package com.mark.twoweek.prefixadd;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sun
 * @date 2021-10-17 11:24
 */
public class _1_LC_1248 {
    // 1、问题转换-》子段和-》前缀和相减
    // prefixAdd中存储的数组奇数的个数，偶数%2=0
    // k个奇数就变成子段和等于k
    // sum(l, r) == k
    // s[r] - s[l - 1] == sum(l, r) 【l <= r，才是一个合法区间】
    // 两数之和
    // s[i] + s[j] == k, s[j] = k - s[i]
    // 两数之差：一个是s[r]，一个是s[l - 1]
    // s[j] = s[i] - k
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1] % 2;
        }

        // 两数之差，可以使用数组也可使用map
        // 使用数组index记录
        int[] count = new int[n + 1];
        count[sum[0]]++; // sum[0]==0同样需要在count数组中计数；这里不要强行和奇数个数产生关联，问题本身已经转换，子段和计算需要
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (sum[i] - k >= 0) { // 非负数进行累加
                // 累加符合预期的值，count数组值未发生变化
                ans += count[sum[i] - k]; // index为前缀和的值，sum[i] - k可能为零，所以需要首先将count[sum[0]]++初始化
            }
            // 对应index为前缀和，并计数值加+1
            count[sum[i]]++;
        }
        return ans;
    }

    // 使用hashmap，参照两数之和
    public int numberOfSubarrays2(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1] % 2;
        }

        // 两数之差，可以使用数组也可使用map
        Map<Integer, Integer> indexMap = new HashMap<>(); // <sum[i], number>
        indexMap.put(sum[0], 1); // sum[0]，用于保证计算子段和从第一个数开始数组不越界s[l - 1]==s[0]
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            indexMap.put(sum[i], indexMap.getOrDefault(sum[i], 0) + 1);
            if (indexMap.containsKey(sum[i] - k)) {
                ans += indexMap.get(sum[i] - k);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new _1_LC_1248().numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3);
        new _1_LC_1248().numberOfSubarrays2(new int[]{1, 1, 1, 1, 1}, 1); // 5
    }
}
