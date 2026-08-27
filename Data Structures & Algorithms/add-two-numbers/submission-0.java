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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans=new ListNode(0);
        ListNode cur=ans;
        int carry=0;
        while(l1!=null || l2!=null || carry!=0){
            int num=carry;
            if(l1!=null && l2!=null){
                num+=l1.val+l2.val;
                l1=l1.next;
                l2=l2.next;
            } 
            else if(l1==null && l2!=null){
                num+=l2.val;
                l2=l2.next;
            } 
            else if(l1!=null && l2==null){
                num+=l1.val;
                l1=l1.next;
            } 

            
                
            carry=num/10;
            num=num%10;
            
            cur.next= new ListNode(num);
            cur=cur.next;

        }
     
        return ans.next;
    }
}