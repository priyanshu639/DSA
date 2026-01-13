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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1=l1;
        ListNode t2=l2;
        ListNode dummy=new ListNode(-1);
        ListNode d1=dummy;
        int carry=0;
        while(t1!=null || t2!=null ){
            int val1=0;
            int val2=0;
            
            if(t1!=null) val1=t1.val;
            if(t2!=null) val2=t2.val;
            ListNode node=new ListNode((val1+val2+carry)%10);
            d1.next=node;
            d1=d1.next;
            // here we are checking the sum of all value and caary should greater then nine it means there should be a carry which is equal to 1 , here when you add two single digit number then it will never become 20 so carry can only be one 
            if(val1+val2+carry>9){
                carry=1;
            }
            else{
                carry=0;
            }
            if(t1!=null)t1=t1.next;
            if(t2!=null)t2=t2.next;
            
            


        }
        // here also the same logic 
        if(carry==1){
            ListNode newnode=new ListNode(carry);
            d1.next=newnode;
            d1=d1.next;

        }
        return dummy.next;
    }
}