package com.mark.threeweek.homework.treetraversal;

/**
 * @author sun
 * @date 2021-11-06 15:11
 */
public class _4_LC_106 {
    private int[] inorder;
    private int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        return build(0, inorder.length - 1, 0, postorder.length - 1);
    }

    // inorder [l1, r1]; postorder [l2, r2]
    private TreeNode build(int l1, int r1, int l2, int r2) {
        if (l1 > r1) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[r2]); // 后序找到root
        int mid = l1;
        while (inorder[mid] != root.val) { // 找到中序的root，左侧左子树，右侧右子树
            mid++;
        }
        // l1 ~ mid-1 左子树中序
        // mid+1 ~ r1 右子树中序
        root.left = build(l1, mid - 1, l2, l2 + mid - l1 - 1); // 中序边界 + 后序边界
        root.right = build(mid + 1, r1, l2 + mid - l1, r2 - 1);
        return root;
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
