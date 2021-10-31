package com.mark.week4.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sun
 * @date 2021-10-28 22:07
 */
public class _1_LC_17 {
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    // 1、暴力
    public List<String> letterCombinations_1(String digits) {
        char[] digitArray = digits.toCharArray();
        List<String> ans = new ArrayList<>();
        // TODO lambda简化
        for (char digit : digitArray) {
            String letters = phoneMap.get(digit);
            char[] letterArray = letters.toCharArray();
            if (ans.size() == 0) {
                for (char letter : letterArray) {
                    ans.add(String.valueOf(letter));
                }
            } else {
                List<String> temp = new ArrayList<>(ans);
                ans.clear();
                for (char letter : letterArray) {
                    for (String str : temp) {
                        ans.add(str + letter);
                    }
                }
            }
        }
        return ans;
    }

    // 2、dfs
    // 数字对应的字母时不变的
    private char[] digits;

    private List<String> ans;

    public List<String> letterCombinations(String digits) {
        this.digits = digits.toCharArray();
        this.ans = new ArrayList<>();
        if (digits.isEmpty()) {
            return ans;
        }
        dfs(0, "");
        return ans;
    }

    private void dfs(int index, String string) { // 两个状态作为参数
        if (index == digits.length) {
            ans.add(string);
            return;
        }
        for (char ch : phoneMap.get(digits[index]).toCharArray()) {
            dfs(index + 1, string + ch);
        }
    }

    // TODO 回溯不需要mark[]，可以直接做为啥？


    public static void main(String[] args) {
        new _1_LC_17().letterCombinations("23");
    }
}
