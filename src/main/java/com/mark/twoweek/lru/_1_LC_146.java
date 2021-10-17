package com.mark.twoweek.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sun
 * @date 2021-10-17 10:30
 */
public class _1_LC_146 {
}

class LRUCache {
    private Map<Integer, Node> map = new HashMap<>();

    private Node head;

    private Node tail;

    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // 如果有该节点定位到该节点，并提升到最新的位置
        Node node = map.get(key);
        remove(node);
        insert(head, node);
        return node.value;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            Node node = new Node();
            node.value = value;
            node.key = key;
            map.put(key, node);
            insert(head, node);
            if (map.size() > capacity) {
                map.remove(tail.pre.key);
                remove(tail.pre);
            }
        } else {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insert(head, node);
        }
    }

    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    // 双链表的插入操作
    private void insert(Node head, Node node) {
        head.next.pre = node;
        node.next = head.next;

        head.next = node;
        node.pre = head;
    }
}

class Node {
    int value;
    int key;
    Node pre;
    Node next;
}