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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null) return head;

        int n=1;
        ListNode temp = head;
        while(temp.next!=null){
            temp=temp.next;
            n++;
        }
        temp.next=head;
        k%=n;
        temp=head;
        ListNode prev = temp;
        for(int i=0; i<n-k; i++){
            prev=temp;
            temp=temp.next;
        }
        prev.next = null;
        // System.out.println(n);
        return temp;
    }
}