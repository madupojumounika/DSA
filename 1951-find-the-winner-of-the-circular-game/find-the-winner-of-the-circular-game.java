class Solution {
    public int findTheWinner(int n, int k) {
        Node head = new Node(1);
        Node curr = head;

        for(int i = 2; i <= n; i++){
            curr.next = new Node(i);
            curr = curr.next;
        }
        curr.next = head;

        while(curr.next != curr){
            for(int i = 1; i < k; i++){
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }
        return curr.val;
    }
}

class Node{
    int val;
    Node next;

    Node(int val){
        this.val = val;
    }
}