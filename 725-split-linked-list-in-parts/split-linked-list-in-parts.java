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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        if(head==null||head.next==null){
            if(head==null) return ans;
            if(k>0){
                ans[0]=head;
                return ans;
            }
        }
        int n =1;
        ListNode temp = head;
        while(temp.next!=null){
            temp=temp.next; n++;
        }
        if(k>n){
            
            temp=head;
            int i=0;
            while(temp!=null){
                ListNode newNode = temp;
                temp=temp.next;
                newNode.next=null;
                ans[i]=newNode;
                i++;
            }
            while(i<n){
                ans[i++]=null;
            }
            return ans;
        }
        int size=n/k;
        int r=n%k;
        temp=head;
        int i=0;
        while(i<k){
            ListNode newNode = temp;
            ListNode newHead=newNode;
            for(int i1=0; i1<size-1; i1++){
                newNode = newNode.next;
            }
            if(r>0){
                newNode=newNode.next;
                r--;
            }
            temp=newNode.next;
            newNode.next=null;
            ans[i++]=newHead;
        }
        return ans;
    }
}