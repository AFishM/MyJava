package algorithm.hashmap;

import algorithm.listnode.ListNode;

import java.util.HashSet;

public class MyHashSet {
    private ListNode[] listNodes=new ListNode[16];
    /** Initialize your data structure here. */
    public MyHashSet() {

    }

    public void add(int key) {
        int index=getIndex(key);
        ListNode listNode=listNodes[index];
        if(listNode!=null){
            if(listNode.getVal()==key){
                return;
            }
            while (listNode.getNext()!=null){
                listNode=listNode.getNext();
                if(listNode.getVal()==key){
                    return;
                }
            }
            listNode.setNext(new ListNode(key));
        }else{
            listNodes[index]=new ListNode(key);
        }
    }

    public void remove(int key) {
        int index=getIndex(key);
        ListNode listNode=listNodes[index];
        ListNode preNode=null;
        if(listNode!=null){
            while (listNode!=null){
                if(listNode.getVal()==key){
                    if(preNode==null){
                        listNodes[index]=listNode.getNext();
                    }else{
                        preNode.setNext(listNode.getNext());
                    }
                    listNode.setNext(null);
                    break;
                }
                preNode=listNode;
                listNode=listNode.getNext();
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index=getIndex(key);
        ListNode listNode=listNodes[index];
        if(listNode!=null){
            while (listNode!=null){
                if(listNode.getVal()==key){
                    return true;
                }
                listNode=listNode.getNext();
            }
        }
        return false;
    }

    private int getIndex(int key){
        return key%listNodes.length;
    }
}
