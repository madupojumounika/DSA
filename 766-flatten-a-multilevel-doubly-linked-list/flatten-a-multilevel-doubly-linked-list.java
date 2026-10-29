/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null){
            return head;
        }
        Node current = head;

        while(current != null){
            if(current.child != null){
                Node childHead = current.child;
                Node originalNext = current.next;

                current.next = childHead;
                childHead.prev = current;

                Node tail = childHead;
                while(tail.next != null){
                    tail = tail.next;
                }
                tail.next = originalNext;

                if(originalNext != null){
                    originalNext.prev = tail;
                }
                current.child = null;
            }
            current = current.next;
        }

        return head;
    }
}