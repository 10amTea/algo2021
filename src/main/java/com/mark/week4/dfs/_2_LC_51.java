package com.mark.week4.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sun
 * @date 2021-10-31 15:32
 */
public class _2_LC_51 {
    private int n;

    private boolean used[];

    // Java map元素不包含直接为null
    private Map<Integer, Boolean> usedPlus = new HashMap<>();

    private Map<Integer, Boolean> usedMinus = new HashMap<>();

    private List<Integer> p; // 排列

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.used = new boolean[n];
        Arrays.fill(used, false);
        dfs(0);
        return null;
    }

    private void dfs(int row) { // 行
        if (row == n) {
            ans.add(new ArrayList<>(p)); // 列信息
            return;
        }
        for (int col = 0; col < n; col++) {
            if (used[col] && usedPlus.get(row + col) && usedMinus.get(row - col)) {
                p.add(col);
                used[col] = true;
                usedPlus.put(row + col, true);
                usedMinus.put(row - col, true);
                dfs(row + 1);
                used[col] = false;
                usedPlus.put(row + col, false);
                usedMinus.put(row - col, false);
                p.remove(p.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        new _2_LC_51().solveNQueens(4);
    }
}
