package algorithm.listnode;

/**
 * Created by xuzixu on 2019/7/22.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode init(int[] arrays){
        if(arrays==null||arrays.length==0){
            return null;
        }
        ListNode listNode=new ListNode(arrays[0]);
        ListNode tempNode=listNode;
        for(int i=1;i<arrays.length;i++){
            tempNode.next=new ListNode(arrays[i]);
            tempNode=tempNode.next;
        }
        return listNode;
    }
}
