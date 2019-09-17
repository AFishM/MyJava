package algorithm.leetcode.tencent.linklist;

public class MyLinkedList {
    Node head;
    Node tail;
    int length;

    public MyLinkedList() {
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= length) {
            return -1;
        }
        if (head == null) {
            return 0;
        }
        Node node = head;
        int position = 0;
        while (position < index) {
            node = node.nextNode;
            position++;
        }
        return node.x;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            node.nextNode = head;
            head = node;
        }
        length++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node node = new Node(val);
        if (tail == null) {
            tail = node;
            head = node;
        } else {
            tail.nextNode = node;
            tail = node;
        }
        length++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > length) {
            return;
        }
        if (index <= 0) {
            addAtHead(val);
        } else if (index == length) {
            addAtTail(val);
        } else {
            Node node = new Node(val);
            Node temp = head;
            int position = 1;
            while (position < index) {
                temp = temp.nextNode;
                position++;
            }
            node.nextNode = temp.nextNode;
            temp.nextNode = node;
            length++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) {
            return;
        }
        int position = 0;
        Node pre = null;
        Node temp = head;
        while (position < index) {
            pre = temp;
            temp = temp.nextNode;
            position++;
        }
        if (pre == null) {
            head = head.nextNode;
        } else if (temp.nextNode == null) {
            pre.nextNode = null;
            tail = pre;
        } else {
            pre.nextNode = temp.nextNode;
        }
        length--;
    }

    static class Node {
        int x;
        Node nextNode;

        Node(int x) {
            this.x = x;
        }
    }
}
