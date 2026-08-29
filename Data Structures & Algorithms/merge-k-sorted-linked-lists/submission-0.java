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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        
        return mergerange(lists,0,lists.length-1);
    }
    public ListNode mergerange(ListNode[] lists,int l,int r){
        if(l==r) return lists[l];
        int mid=l+(r-l)/2;
        ListNode left = mergerange(lists,l,mid);
        ListNode right=mergerange(lists,mid+1,r);
        return merge2list(left,right);
    }
    public ListNode merge2list(ListNode l1,ListNode l2){
        ListNode temp= new ListNode(0);
        ListNode dummy=temp;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                dummy.next=l1;
                l1=l1.next;
            }
            else{
                dummy.next=l2;
                l2=l2.next;
            }
            dummy=dummy.next;
        }
        if(l1!=null){
            dummy.next=l1;
        }else{
            dummy.next=l2;
        }
        return temp.next;
    }
}