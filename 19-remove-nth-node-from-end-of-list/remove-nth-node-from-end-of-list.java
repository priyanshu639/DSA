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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            len++;
        }
        if(len==1) return null;//ye line nhi likhoge tp bhu ch jayega ye head.next wala handled kr lega
        
        // agar len aur n eqaula h it means head ko delete karn h
        if(len==n) {
            head=head.next;
            return head;
        }
        int m=len-n; // ye previous node h 
        ListNode x=head;
        for(int i=1;i<=m-1;i++){
            x=x.next;
        }
        // abb x jo h wo prev pe h
        x.next=x.next.next;
        return head;

        
    }
}