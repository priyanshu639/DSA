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
    // Method 2 (Slow Fast approach)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // put slow and fast at head then move fast to n th position from start then move slow anf fast together one one step 

        ListNode slow=head;
        ListNode fast=head;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        if(fast==null) return head.next;
        // now fast is at nth postion from start

        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        // now delte the slow.next wala node
        slow.next=slow.next.next;
        return head;

        
    }
}