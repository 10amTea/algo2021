package com.mark.threeweek.homework.treetraversal;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sun
 * @date 2021-11-06 14:56
 */
public class _3_LC_429 {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<Pair<Node, Integer>> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        queue.add(new Pair<Node, Integer>(root, 0));
        while (!queue.isEmpty()) {
            Node node = queue.peek().getKey();
            int depth = queue.poll().getValue();
            if (depth >= ans.size()) {
                ans.add(new ArrayList<>());
            }
            ans.get(depth).add(node.val);
            for (Node child : node.children) {
                queue.add(new Pair<Node, Integer>(child, depth + 1));
            }
        }
        return ans;
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
