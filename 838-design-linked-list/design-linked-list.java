class MyLinkedList {
    Node head;

    public MyLinkedList() {
        head = null;
    }
    
    public int get(int index) {
        Node current = head;
        for(int i = 0; i < index; i++){
            if(current == null){
                return -1;
            }
            current = current.next;
        }

        if(current == null){
            return -1;
        }
        return current.data;  
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);

        if(head == null){
            head = newNode;
            return;
        }

        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
        
    }
    
    public void addAtIndex(int index, int val) {
        if(index == 0){
            addAtHead(val);
            return;
        }
        if(index < 0){
            return;
        }
    
        Node current = head;
        for(int i = 0; i < index - 1; i++){
            if(current == null){
                return;
            }
            current = current.next;
        }
        if(current == null){
                return;
        }
        Node newNode = new Node(val);

        newNode.next = current.next;
        current.next = newNode;
        
    }
    
    public void deleteAtIndex(int index) {
        if(head == null || index < 0){
            return;
        }

        if(index == 0){
            head = head.next;
            return;
        }

        Node current = head;
        for(int i = 0; i < index - 1; i++){
            if(current.next == null){
                return;
            }
            current = current.next;
        }
        if(current.next == null){
            return;
        }
        current.next = current.next.next;
    }
}

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */