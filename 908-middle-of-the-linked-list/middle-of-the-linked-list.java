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
    public ListNode middleNode(ListNode head) {
        int size=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        // if(size%2==0){
        //     size=size/2;

        // }
        // else{
        //     size=size/2;
        // }
        size=size/2;
        ListNode x=head;
        for(int i=0;i<size;i++){
            x=x.next;

        }

        return x;
        
    }
}