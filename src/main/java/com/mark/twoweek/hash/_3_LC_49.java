package com.mark.twoweek.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sun
 * @date 2021-10-16 22:31
 */
public class _3_LC_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        // Java浅拷贝
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            // TODO 字符数组转换String不同方式的差异
            String orderStr = Arrays.toString(chars); // "[a, e, t]"
//            String orderStr2 = String.valueOf(chars); // "aet"
            List<String> stringList = groups.getOrDefault(orderStr, new ArrayList<>());
            stringList.add(str);
            groups.put(orderStr, stringList);
        }
        List<List<String>> ans = new ArrayList<>();
        groups.forEach((key, value) -> ans.add(value));
        return ans;
    }

    public static void main(String[] args) {
        new _3_LC_49().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
