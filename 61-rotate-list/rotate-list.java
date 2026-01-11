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
    public ListNode rotateRight(ListNode head, int k) {
       
        if(head==null || head.next==null  )return head;
        ListNode temp=head;
        int len=0;
        while(temp!=null){
            temp=temp.next;
            len++;
        }
         k%=len;
        if(k==0  )return head;
         

        ListNode slow=head;
        ListNode fast=head;
        for(int i=0;i<k;i++) fast=fast.next;
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        ListNode t=slow.next;
        slow.next=null;
        fast.next=head;
        return t;
    }
}

 // not correct
        // ListNode temp=head;
        // int len=0;
        // while(temp!=null){
        //     temp=temp.next;
        //     len++;
        // }
        // ListNode lastnode=temp;
        // // length=len-k+1
        // temp=head;
        // for(int i=1;i<len-k;i++){
        //     temp=temp.next;
        // }
        // // temp abhi previous of k pe h;
        // temp.next=null;
        // lastnode.next=head;
        // return temp;