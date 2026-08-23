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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode second=slow.next;
        slow.next=null;

        ListNode prev=null;

        while(second!=null){
            ListNode next=second.next;
            second.next=prev;
            prev=second;
            second=next;
        }
        second=prev;
        ListNode first=head;
        while(second!=null){
                ListNode nextfirst=first.next;
                ListNode nextsecond=second.next;
                first.next=second;
                second.next=nextfirst;
                first=nextfirst;
                second=nextsecond;
        }
        
    }
}