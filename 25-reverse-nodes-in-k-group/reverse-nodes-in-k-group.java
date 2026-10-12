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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prevGroup = temp;

        while(true){
            //find kth node
            ListNode kth = prevGroup;

            for(int i = 0; i < k; i++){
                if(kth == null){
                    break;
                }
                kth = kth.next;
            }

            if(kth == null){
                break;
            }
            
            ListNode nextGroup = kth.next;   //save next group

            //reverse next group
            ListNode prev = nextGroup;
            ListNode curr = prevGroup.next;

            while(curr != nextGroup){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            //reconnect
            ListNode oldGroupHead = prevGroup.next;
            prevGroup.next = kth;
            prevGroup = oldGroupHead;
        }
        return temp.next;
    }
}