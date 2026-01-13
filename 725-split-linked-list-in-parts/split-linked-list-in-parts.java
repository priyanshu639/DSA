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
    public int lengthofll(ListNode head){
        int len=0;
        ListNode temp=head;
        while(temp!=null){
            len++;
            temp=temp.next;
            
        }
        return len;
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n=lengthofll(head);
        int size=n/k;
        int extra=n%k;
        ListNode[] arr=new ListNode[k];
        int idx=0;
        int len=1;
        ListNode temp=head;
        while(temp!=null){
            int s=size;
            if(extra>0)s++;
            if(len==1) arr[idx++]=temp;
            if(len==s){
                ListNode a=temp.next;
                temp.next=null;
                temp=a;
                len=1;
                extra--;
                

            }
            else{
                len++;
                temp=temp.next;

            }
            
        }
        return arr;
        
    }
}