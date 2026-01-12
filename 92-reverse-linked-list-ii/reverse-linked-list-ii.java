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
    public void reverseList(ListNode head) {
        
        ListNode prev=null;
        ListNode curr=head;
        ListNode Next=head;//yaha pe Next=null tab bhi chalega 
        
        while(curr!=null){
            Next=curr.next;
            
            curr.next=prev;
            prev=curr;
            curr=Next;
            
        }
        
        
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next==null || left==right) return head;
        ListNode a=null,b=null,c=null,d=null;
        ListNode temp=head;
        int pos=1;
        while(temp!=null){
            if(pos==left-1) a=temp;
            if(pos==left) b=temp;
            if(pos==right+1) d=temp;
            if(pos==right) c=temp;
            temp=temp.next;
            pos++;
        }
        if(a!=null)a.next=null;

        if(c!=null)c.next=null;
        reverseList(b);
        if(a!=null)a.next=c;
        b.next=d;
        if(a==null) return c;
        return head;
        
    }
}