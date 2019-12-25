package algorithm.hashmap;

import javafx.util.Pair;

import java.util.HashMap;

public class MyHashMap {
    private Node[] nodes = new Node[16];

    public MyHashMap() {

    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int index = getIndex(key);
        Node node = nodes[index];
        if (node == null) {
            nodes[index] = new Node(key, value);
            return;
        }
        if (node.key == key) {
            node.value = value;
            return;
        }
        while (node.next != null) {
            node = node.next;
            if (node.key == key) {
                node.value = value;
                return;
            }
        }
        node.next = new Node(key, value);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int index = getIndex(key);
        Node node = nodes[index];
        if (node == null) {
            return -1;
        }
        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int index = getIndex(key);
        Node node = nodes[index];
        if (node == null) {
            return;
        }
        Node preNode = null;
        while (node != null) {
            if (node.key == key) {
                if (preNode == null) {
                    nodes[index] = node.next;
                } else {
                    preNode.next = node.next;
                }
                node.next = null;
            }
            preNode = node;
            node = node.next;
        }
    }

    private int getIndex(int key) {
        return key % nodes.length;
    }

    static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
