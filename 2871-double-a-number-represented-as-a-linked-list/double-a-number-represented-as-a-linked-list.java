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
    private ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev = null;
        while(curr!=null){
            ListNode nxt = curr.next;
            curr.next=prev;
            prev=curr;
            // System.out.print(prev.val+"->");
            curr=nxt;
        }
        return prev;
    }
    public ListNode doubleIt(ListNode head) {
        ListNode temp = reverse(head);
        ListNode revNode=temp;
        int carry=0;
        ListNode prev = temp;
        while(temp!=null){
            int val = temp.val*2+carry;
            temp.val = val%10;
            carry=val/10;
            prev=temp;
            temp=temp.next;
        }
        if(carry>0){
            prev.next=new ListNode(1);
            prev=prev.next;
        }
        return reverse(revNode);
    }
}