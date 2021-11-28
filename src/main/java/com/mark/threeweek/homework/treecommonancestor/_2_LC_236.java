package com.mark.threeweek.homework.treecommonancestor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sun
 * @date 2021-11-06 15:15
 */
public class _2_LC_236 {
    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();

    Set<Integer> visited = new HashSet<Integer>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root); // 记录每个节点的父节点
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val); // 找到p的父节点
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val); // 找到q的父节点
        }
        return null;
    }

    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
