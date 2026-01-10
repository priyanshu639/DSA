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
    public ListNode swapNodes(ListNode head, int k) {

        ListNode temp=head;
        for(int i=0;i<k-1;i++){
            temp=temp.next;
        }
        // abb temp node k th node from starting se aa gaya

        // now find starting from last kth node;
        int len=0;
        ListNode length=head;
        while(length!=null){
            length=length.next;
            len++;
        }
        // len-k for going to the kth index from last
        ListNode last=head;

        for(int i=0;i<len-k;i++){
            last=last.next;

        }
        // last is at kthnode from starting with last se kth node
        int p=temp.val;
        temp.val=last.val;
        last.val=p;
        return head;



        
    }
}