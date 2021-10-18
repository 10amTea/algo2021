package com.mark.oneweek.monotonestack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sun
 * @date 2021-10-18 23:00
 */
public class _2_LC_42 {
    // 这波单调栈需要递减 42
    // 最大图形递增 84
    public int trap(int[] heights) {
        Deque<Rectangle> stack = new ArrayDeque<>();
        int ans = 0;
        for (int height : heights) {
            int accumulatedWidth = 0;
            while (!stack.isEmpty() && height >= stack.peekLast().height) { // 一旦出现递增的就需要计算，否者可以一直流向低处
                int bottom = stack.peekLast().height;
                accumulatedWidth += stack.peekLast().width;
                stack.removeLast();
                if (stack.isEmpty()) { // 水从左边流走了
                    continue;
                }
                // 以bottom为底的横块水，最高可以到up(左右两侧高度的min)，计算横块水的高度up - bottom
                int up = Math.min(height, stack.peekLast().height);
                ans += accumulatedWidth * (up - bottom);
            }
            stack.addLast(new Rectangle(accumulatedWidth + 1, height));
        }
        return ans;
    }

    private static class Rectangle {
        private int width;

        private int height;

        private Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }

    // 利用前缀preMax[]和sufMax[]计算竖条的盛水面积
    public int trap2(int[] heights) {
        int n = heights.length;
        int[] preMax = new int[n];
        preMax[0] = heights[0];
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], heights[i]);
        }
        int[] sufMax = new int[n];
        sufMax[n - 1] = heights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sufMax[i] = Math.max(sufMax[i + 1], heights[i]);
        }
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            int up = Math.min(preMax[i - 1], sufMax[i + 1]);
            int bottom = heights[i];
            if (up > bottom) {
                ans += up - bottom;
            }

        }
        return ans;
    }
}
