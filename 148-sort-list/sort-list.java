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
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode dummy=new ListNode(-1);
        ListNode t=dummy;
        ListNode t1=list1;
        ListNode t2=list2;
        while(t1!=null && t2!=null){
            if(t1.val<=t2.val){
                t.next=t1;
                t1=t1.next;;
                
            }
            else{
                t.next=t2;
                t2=t2.next;
            }
            t=t.next;
            
        }
        if(t1==null) t.next=t2;
        else t.next=t1;
        return dummy.next;
        
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode a=head;
        ListNode slow=head;
        ListNode fast=head;
        // break them into two sub parts
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode b=slow.next;
        slow.next=null;

        // now do magic that is send them recursively to sort it
        a=sortList(a);
        b=sortList(b);//in dono me a aur b me store isliye kr rhe h kyuki is method ka leturn type ListNode h


        // merge both list a and b
        ListNode ans=mergeTwoLists(a,b);
        return ans;

        
    }
}