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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele: nums) set.add(ele);
        while(head!=null && set.contains(head.val)) head=head.next;
        if(head==null) return null;
        ListNode prev = head;
        ListNode curr = head.next;
        while(curr!=null){
            if(set.contains(curr.val)){
                prev.next=curr.next;
            }
            else prev = curr;
            curr = curr.next;
        }
        return head;
    }
}