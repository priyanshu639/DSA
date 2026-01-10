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
    public ListNode deleteMiddle(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;

        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=dummy;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            prev=prev.next;
            fast=fast.next.next;
        }
        prev.next=slow.next;
        return dummy.next;
        
        
    }
}