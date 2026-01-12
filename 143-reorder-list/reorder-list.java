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
    public ListNode reverseList(ListNode head) {
        
        ListNode prev=null;
        ListNode curr=head;
        ListNode Next=head;//yaha pe Next=null tab bhi chalega 
        
        while(curr!=null){
            Next=curr.next;
            
            curr.next=prev;
            prev=curr;
            curr=Next;
            
        }
        return prev;
        
    }
    public void reorderList(ListNode head) {
        ListNode temp=head;
        ListNode slow=head;
        ListNode fast=head;
        // left middle niklane ke liye 
        while(fast.next!=null && fast.next.next!=null)  {
            slow=slow.next;
            fast=fast.next.next;

        }
        // slow jo h wahi mid h even length ke liye
        ListNode head2=slow.next;
        slow.next=null;
        head2=reverseList(head2);
        ListNode dummy=new ListNode(-1);
        temp=head;
        ListNode t=dummy;
        while(temp!=null && head2!=null){
            t.next=temp;
            temp=temp.next;
            t=t.next;
            t.next=head2;
            head2=head2.next;
            t=t.next;
           
        }
        if(temp!=null) t.next=temp;
        if(head2!=null) t.next=head2;
        head=dummy.next;

        
        
    }
}