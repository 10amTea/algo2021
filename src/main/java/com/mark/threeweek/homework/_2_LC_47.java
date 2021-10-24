package com.mark.threeweek.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sun
 * @date 2021-10-24 22:06
 */
public class _2_LC_47 {
    // 脑子固有的概念，尽然会认为枚举不全...
    // 通过mark[]和for循环枚举回溯，必然是个全集，只是需要做到去重
    // 借由set这种方式的去重，会枚举所有，比较耗时
    // 做好的做法：全排列有重复元素需要进行剪枝
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] mark = new boolean[nums.length];
        dfs(nums, path, res, mark);
        return res;
    }

    private void dfs(int[] nums, List<Integer> path, List<List<Integer>> res, boolean[] mark) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (mark[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !mark[i - 1]) { // mark[i - 1] == false，重复元素回溯的时候被重置false
                continue;
            }
            path.add(nums[i]);
            mark[i] = true;
            dfs(nums, path, res, mark);
            path.remove(path.size() - 1);
            mark[i] = false;
        }
    }
}
