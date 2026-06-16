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
    private void reverse(ListNode head){
        ListNode prev = null;
        ListNode curr=head;
        ListNode nxt=curr;
        while(nxt!=null){
            nxt = curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
    }
    private ListNode kthNode(ListNode head, int k){
        k-=1;
        while(head!=null && k>0){
            head=head.next;
            k--;
        }
        return  head;
    }
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode prev = null;
        ListNode temp = head;
        while(temp!=null){
            ListNode kth = kthNode(temp, k);
            if(kth==null){
                prev.next=temp;
                break;
            }
            ListNode nxt  = kth.next;
            kth.next=null;
            reverse(temp);
            if(temp==head){
                head=kth;
            }
            if(prev!=null)prev.next=kth;
            prev=temp;
            temp = nxt;
        }
       return head;
    }
}