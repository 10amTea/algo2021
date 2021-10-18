package com.mark.oneweek.monotonestack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sun
 * @date 2021-10-18 23:01
 */
public class _3_LC_496_Self {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 通过单调栈找到对应元素的右边的下一个最大的元素
        // 因为数组的所有元素都不相同可以使用map管理映射关系
        // 使用双端队列作为栈的时候，使用比较方法意图比较好理解方法
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int value : nums2) {
            // 单调栈保持的关键点，while循环
            while (!stack.isEmpty() && value > stack.peekLast()) {
                map.put(stack.removeLast(), value);
            }
            stack.addLast(value);
        }
        // 使用foreach无法修改原数组元素
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}
