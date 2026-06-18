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
    public ListNode doubleIt(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode temp = head;
        while(temp!=null){
            st.push(temp);
            temp=temp.next;
        }
        int carry=0;
        while(!st.isEmpty()){
            ListNode curr=st.pop();
            int val=(curr.val)*2+carry;
            curr.val=val%10;
            carry=val/10;
        }
        if(carry>0){
            ListNode newNode = new ListNode(1);
            newNode.next=head;
            return newNode;
        }
        return head;
    }
}