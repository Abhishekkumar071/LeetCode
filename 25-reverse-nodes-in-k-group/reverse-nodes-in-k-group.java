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
        if(head==null ||  k==1) return head;
        ListNode pre = null;
        ListNode curr = head;

        int n = 0;
        while(curr != null){
            n++;
            curr = curr.next;
        }
        curr = head;
        while(n>=k){
            ListNode f = curr;
            ListNode prev = null;
            for(int i=0; i<k; i++){
                ListNode nxt = curr.next;
                curr.next = prev;
                prev=curr;
                curr=nxt;
            }
            if(head==f) head=prev;
            if(pre!=null) pre.next = prev;
            pre = f;
            n-=k;
        }
        if(n>0){
            pre.next=curr;
        }
        return head;
    }
}