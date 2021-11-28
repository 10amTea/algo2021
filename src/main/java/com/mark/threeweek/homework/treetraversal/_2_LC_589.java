package com.mark.threeweek.homework.treetraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sun
 * @date 2021-11-06 14:56
 */
public class _2_LC_589 {
    public List<Integer> preorder(Node root) {
        List<Integer> seq = new ArrayList<>();
        dfs(seq, root);
        return seq;
    }

    private void dfs(List<Integer> list, Node node) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        for (Node curr : node.children) {
            dfs(list, curr);
        }
    }

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
