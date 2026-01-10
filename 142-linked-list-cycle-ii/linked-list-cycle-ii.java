/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode temp=head; 
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) {
                break;
                
            }
        }
        // while loop break tab hoga jab null ajaye ya to slow and fast equal ho jaye it means cycle detect ho jaye
        if(fast!=slow) return null;
        while(temp!=slow){
            temp=temp.next;
            slow=slow.next;
            
        }
        return slow;
        
        
    }
}