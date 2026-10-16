class LRUCache {

    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
        
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtTail(Node node){
        Node beforeTail = tail.prev;
        
        beforeTail.next = node;
        node.prev = beforeTail;

        node.next = tail;
        tail.prev = node;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        insertAtTail(node);

        return node.value;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;

            remove(node);
            insertAtTail(node);
            return;
        }

        if(map.size() == capacity){
            Node lru = head.next;

            remove(lru);
            map.remove(lru.key);
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insertAtTail(newNode);   
    }
}

class Node{
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value){
        this.key = key;
        this.value = value;

    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */