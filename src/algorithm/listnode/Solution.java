package algorithm.listnode;

/**
 * Created by xuzixu on 2019/7/22.
 */
public class Solution {
    public static void main(String[] args) {
//        int[] a={4,1,8,4,5};
//        int[] b={5,0,1,8,4,5};
//        ListNode listNode=new Solution().getIntersectionNode(ListNode.init(a),ListNode.init(b));

//        int[] c={1,2};
//        new Solution().removeNthFromEnd(ListNode.init(c),1);
        int[] a = {1, 2, 3, 4, 5};
        new Solution().reverseList(ListNode.init(a));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        if (headA == headB) {
            return headA;
        }
        int lengthA = 0;
        int lengthB = 0;
        ListNode tempA = headA;
        while (tempA != null) {
            lengthA++;
            tempA = tempA.next;
        }
        ListNode tempB = headB;
        while (tempB != null) {
            lengthB++;
            tempB = tempB.next;
        }
        tempA = headA;
        tempB = headB;
        if (lengthA > lengthB) {
            while (lengthA > lengthB) {
                tempA = tempA.next;
                lengthA--;
            }
        } else {
            while (lengthA < lengthB) {
                tempB = tempB.next;
                lengthB--;
            }
        }
        while (tempA != null) {
            if (tempA == tempB) {
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tempNode = head;
        while (n > 0) {
            if (tempNode == null) {
                return head;
            }
            tempNode = tempNode.next;
            n--;
        }
        if (tempNode == null) {
            return head.next;
        }
        ListNode preNode = null;
        ListNode targetNode = head;
        while (tempNode != null) {
            preNode = targetNode;
            targetNode = targetNode.next;
            tempNode = tempNode.next;
        }
        preNode.next = targetNode.next;
        return head;
    }

    /**
     * 反转链表
     * 迭代写法
     */
//    public ListNode reverseList(ListNode head) {
//        ListNode tempNode = head;
//        head = null;
//        ListNode nextNode;
//        while (tempNode != null) {
//            nextNode = tempNode.next;
//            tempNode.next = head;
//            head = tempNode;
//            tempNode = nextNode;
//        }
//        return head;
//    }

    /**
     * 反转链表
     * 递归写法
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        return reverseList(head, null);
    }

    private ListNode reverseList(ListNode node, ListNode head) {
        ListNode nextNode = node.next;
        node.next = head;
        if (nextNode == null) {
            return node;
        }
        return reverseList(nextNode, node);
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = null;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val == val) {
                if (pre == null) {
                    head = temp.next;
                } else {
                    pre.next = temp.next;
                }
            } else {
                pre = temp;
            }
            temp = temp.next;
        }
        return head;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        ListNode preNode = null;
        ListNode prePreNode;
        while (fastNode != null && fastNode.next != null) {
            prePreNode = preNode;
            preNode = slowNode;
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            preNode.next = prePreNode;
        }
        ListNode node1 = slowNode.next;
        slowNode.next = preNode;
        ListNode node2 = fastNode == null ? slowNode.next : slowNode;
        while (node1 != null) {
            if (node1.val != node2.val) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }

    /**
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
     * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode even = head;
        ListNode odd = head.next;
        ListNode oddHead = odd;
        while (odd != null && odd.next != null) {
            even.next = odd.next;
            even = even.next;
            odd.next = even.next;
            odd = odd.next;
        }
        even.next = oddHead;

        return head;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        ListNode listNode = null;
        ListNode temp;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp = l1;
                l1 = l1.next;
            } else {
                temp = l2;
                l2 = l2.next;
            }
            if (listNode == null) {
                listNode = temp;
            } else {
                listNode.next = temp;
                listNode = listNode.next;
            }
            if (head == null) {
                head = temp;
            }
        }
        if (l1 == null) {
            listNode.next = l2;
        } else {
            listNode.next = l1;
        }
        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode node = null;
        ListNode temp;
        int value;
        boolean add1 = false;
        while (l1 != null && l2 != null) {
            value = l1.val + l2.val;
            if (add1) {
                value = value + 1;
            }
            if (value >= 10) {
                value = value - 10;
                add1 = true;
            } else {
                add1 = false;
            }
            temp = new ListNode(value);
            if (node == null) {
                node = temp;
                head = node;
            } else {
                node.next = temp;
                node = node.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null) {
            l1 = l2;
        }

        while (l1 != null) {
            if (add1) {
                value = l1.val + 1;
                if (value >= 10) {
                    value = value - 10;
                    add1 = true;
                } else {
                    add1 = false;
                }
                node.next = new ListNode(value);
                node = node.next;
            } else {
                if (node == null) {
                    head = l1;
                } else {
                    node.next = l1;
                }
                break;
            }
            l1 = l1.next;
        }
        if (add1) {
            node.next = new ListNode(1);
        }
        return head;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten(Node head) {
        flattenWithReturnTail(head);
        return head;
    }

    private Node flattenWithReturnTail(Node head) {
        Node node = head;
        Node next;
        Node tail = null;
        while (node != null) {
            tail = node;
            if (node.child != null) {
                next = node.next;
                node.next = node.child;
                node.child.prev = node;
                Node childTail = flattenWithReturnTail(node.child);
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }
                node.child = null;
            }
            node = node.next;
        }
        return tail;
    }
}
