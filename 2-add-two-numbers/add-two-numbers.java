class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;
        ListNode temp = l1;
        int carry = 0;

        // Dono lists jab tak barabar hain
        while(l1 != null && l2 != null) {
            int sum = carry+l1.val+l2.val;
            carry = sum/10;
            l1.val=sum%10;
            temp=l1;
            l1=l1.next; l2=l2.next;
        }

        // Agar l1 lambi hai
        while(l1 != null) {
            int sum = carry+l1.val;
            carry = sum/10;
            l1.val=sum%10;
            temp=l1;
            l1=l1.next;
        }

        // Agar l2 lambi hai
        while(l2 != null) {
            int sum = carry+l2.val;
            carry = sum/10;
            temp.next=l2;
            temp=temp.next;
            temp.val=sum%10;
            l2=l2.next;
        }

        // FIX: Ab temp kabhi null nahi hoga, hamesha list ke aakhiri node par hoga
        if (carry > 0) {
            temp.next=new ListNode(carry);
        }

        return head;
    }
}