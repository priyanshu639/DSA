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
    public boolean isPalindrome(ListNode head) {
        if(head.next==null) return true;
        // deep copy banao
        ListNode newhead=new ListNode(head.val);
        ListNode temp=head.next;
        ListNode temp2=newhead;
        while(temp!=null){
            ListNode newNode=new ListNode(temp.val);
            temp2.next=newNode;
            temp2=temp2.next;
            temp=temp.next;
            


        }
        // reverse kardo deep copy wale ko
        newhead=reverseList(newhead);
        temp=head;
        temp2=newhead;
        // now check both reverselist and original list are same or not
        while(temp!=null){
            if(temp.val!=temp2.val)return false;
            temp=temp.next;
            temp2=temp2.next;
        }
        return true;
        
    }
}