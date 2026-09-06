class Node{
    int key, val;
    Node prev,next;
    public Node(int key,int val){
        this.key=key;
        this.val=val;
    }
}
class LRUCache {
    int capacity;
    HashMap<Integer,Node> h;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
    this.capacity=capacity;
     h =new HashMap<>();
     head= new Node(-1,-1);
     tail= new Node(-1,-1);
    head.next=tail;
    tail.prev=head;
    }
    
    public int get(int key) {
        Node node=h.get(key);
        if(node==null){
            return -1;
        }
        remove(node);
        addfirst(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(capacity==0) return;
        if(h.containsKey(key)){
            Node node= h.get(key);
            node.val=value;
            remove(node);
            addfirst(node);
        }
        else{
        if(h.size()==capacity){
            Node del = tail.prev;
            remove(del);
            h.remove(del.key);
        }
        Node newnode = new Node(key,value);
        h.put(key,newnode);
        addfirst(newnode);
        }
        
    }
    public void remove(Node node){
        Node left=node.prev;
        Node right=node.next;
        left.next=right;
        right.prev=left;
    }
    public void addfirst(Node node){
        Node next=head.next;
        head.next=node;
        node.prev=head;
        node.next=next;
        next.prev=node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */