package com.mark.threeweek.homework.treeserialization;

/**
 * @author sun
 * @date 2021-11-06 15:07
 */
public class _1_LC_297 {
    // 使用后序遍历
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(sb, root);
        String regex = "^,*|,*$"; // 去除字符串头尾的","
        String ans = sb.toString().replaceAll(regex, "");
        System.out.print(ans);
        return ans;
    }

    private void dfs(StringBuilder sb, TreeNode node) {
        if (node == null) {
            sb.append(",null");
            return;
        }
        sb.append("," + String.valueOf(node.val));
        dfs(sb, node.left);
        dfs(sb, node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        seq = data.split(",");
        curr = 0;
        return rebuild();
    }

    private TreeNode rebuild() {
        if ("null".equals(seq[curr])) {
            curr++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(seq[curr]));
        curr++;
        root.left = rebuild();
        root.right = rebuild();
        return root;
    }

    private String[] seq;
    private int curr;

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
