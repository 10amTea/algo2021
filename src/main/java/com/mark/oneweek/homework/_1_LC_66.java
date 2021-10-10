package com.mark.oneweek.homework;

/**
 * @author sun
 * @date 2021-10-10 21:58
 */
public class _1_LC_66 {
    // ac
    // 心理想的，但是没有写出来的...
    // https://leetcode-cn.com/problems/plus-one/solution/hua-jie-suan-fa-66-jia-yi-by-guanpengchn/
    public int[] plusOne2(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0)
                return digits;
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        new _1_LC_66().plusOne(new int[]{1, 2, 9});
    }

    // wa
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        if (digits[length - 1] < 9) {
            digits[length - 1] = digits[length - 1] + 1;
            return digits;
        }
        // 末尾等于9需要考虑进位
        // for (int i = length - 2; i >= 0; i--) {
        // }
        // return digits;

        // String和int[]转换，
        StringBuilder sb = new StringBuilder();
        for (int num : digits) {
            sb.append(num);
        }
        String number = sb.toString();
        int temp = Integer.parseInt(number); // 妥妥超出范围
        Integer result = temp + 1;
        String ans = String.valueOf(result);
        int[] ansArray = new int[ans.length()];
        for (int i = 0; i < ans.length(); i++) {
            ansArray[i] = Integer.parseInt(String.valueOf(ans.charAt(i)));
        }
        return ansArray;
    }
}
