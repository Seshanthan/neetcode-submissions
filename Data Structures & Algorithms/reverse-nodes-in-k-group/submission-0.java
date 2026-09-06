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
        ListNode dummy= new ListNode(0);
        dummy.next=head;
        ListNode gp = dummy;
        while(true){
            ListNode kth =gp;
            for(int i=0;i<k && kth!=null;i++){
                kth=kth.next;
            }
            if(kth==null){
                break;
            }
            ListNode gn=kth.next;
            ListNode prev=gn;
            ListNode cur=gp.next;

            while(cur!=gn){
                ListNode next=cur.next;
                cur.next=prev;
                prev=cur;
                cur=next;
            }
            ListNode old= gp.next;
            gp.next = kth;
            gp = old;

        }
        return dummy.next;
    }
}