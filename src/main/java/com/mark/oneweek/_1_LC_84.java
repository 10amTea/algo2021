package com.mark.oneweek;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 *
 * @author sun
 * @date 2021-09-27 22:55
 */
public class _1_LC_84 {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int[] temp = new int[heights.length + 1];
        // 保证栈最终被弹空
        // 数组拷贝，引用拷贝值拷贝？ TODO
        // 并且基本数据类型会被初始化
        System.arraycopy(heights, 0, temp, 0, heights.length);
        // lambda表达式使用？ TODO
        Deque<Rectangle> stack = new ArrayDeque<>();
        for (int num : temp) {
            int accumulatedWidth = 0;
            while (!stack.isEmpty() && stack.peek().height >= num) {
                accumulatedWidth += stack.peek().width;
                res = Math.max(res, stack.peek().height * accumulatedWidth);
                stack.pop();
            }
            stack.push(new Rectangle(accumulatedWidth + 1, num));
        }
        return res;
    }

    // 静态内部类访问权限控制？ TODO
    private static class Rectangle {
        private int width;
        private int height;

        private Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }
}
