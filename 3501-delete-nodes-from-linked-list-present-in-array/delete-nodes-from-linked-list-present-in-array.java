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
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        HashSet<Integer> set = new HashSet<>();
        for(int ele: nums) set.add(ele);
        while(head!=null){
            if(!set.contains(head.val)){
                temp.next = new ListNode(head.val);
                temp=temp.next;
            }
            head=head.next;
        }
        return dummy.next;
    }
}