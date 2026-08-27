/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node cur=head;
        while(cur!=null){
            
            Node next=cur.next;
            Node copy= new Node(cur.val);
            cur.next=copy;
            copy.next=next;
            cur=next;
            
        }
        cur=head;
        while(cur!=null){
            if(cur.random!=null) cur.next.random=cur.random.next;
            cur=cur.next.next;
        }
        
        Node sec=head;
        Node ans=new Node(0);
        Node temp=ans;

        while(sec!=null){
            temp.next=sec.next;
            sec.next=sec.next.next;
            sec=sec.next;
            temp=temp.next;
            
        }
        
        return ans.next;
    }
}