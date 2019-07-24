package algorithm.listnode;

/**
 * Created by xuzixu on 2019/7/22.
 */
public class Solution {
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
}
