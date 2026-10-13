/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        for(int i = 0; i < lists.length; i++){
            result = mergeTwoLists(result, lists[i]);
        }
        return result;
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b){
        ListNode temp = new ListNode(-1);
        ListNode tail = temp;

        while(a != null && b != null){
            if(a.val <= b.val){
                tail.next = a;
                a = a.next;
            }else{
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        if(a != null){
            tail.next = a;
        }else{
            tail.next = b;
        }
        return temp.next;
    }
}