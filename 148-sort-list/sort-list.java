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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //split
        ListNode second = slow.next;
        slow.next = null;

        //sort
        ListNode left = sortList(head);
        ListNode right = sortList(second);

        //merge
        return merge(left, right);  
    }

    private ListNode merge(ListNode left, ListNode right){
        ListNode temp = new ListNode(0);
        ListNode tail = temp;

        while(left != null && right != null){
            if(left.val <= right.val){
                tail.next = left;
                left = left.next;
            }else{
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        if(left != null){
            tail.next = left;
        }else{
            tail.next = right;
        }
        return temp.next;
    }
}