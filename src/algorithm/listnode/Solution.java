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
}
