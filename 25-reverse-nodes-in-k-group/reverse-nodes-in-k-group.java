class Solution {
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode temp = head.next;
        head.next = null;
        ListNode head2 = reverse(temp);
        temp.next=head;
        return head2;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null) return head;

        int len = 0;
        ListNode temp = head;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        if(len<k) return head;

        int i = 1;
        ListNode t = head;
        while(i < k){
            t = t.next;
            i++;
        }

        ListNode prev = t.next;
        
        t.next = null;
        ListNode head2 = reverseKGroup(prev,k);

        ListNode newHead = reverse(head);
        head.next = head2;
        return newHead;

        
    }
}