/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node deepcopy(Node head){
     
       Node head2=new Node(head.val);
       Node t1=head.next;
       Node t2=head2;
       while(t1!=null){
        Node node=new Node(t1.val);
        t2.next=node;
        t2=t2.next;
        t1=t1.next;
       }
       return  head2;
    }

    public void connectAlternatively(Node head,Node head2){
         Node dummy=new Node(-1);
        Node t=dummy;
        Node head1=head;
        
        while(head1!=null && head2!=null){
            t.next=head1;
            head1=head1.next;
            t=t.next;
            t.next=head2;
            head2=head2.next;
            t=t.next;

        }
    }
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        Node head2=deepcopy(head);//deep copy done 
        // STEP -2
        // join these two linkedlist alternatively,using the concept of merge two LL
        connectAlternatively(head,head2);
       

        // step 3 
        // Assign random pointer
        Node t1=head;
        Node t2=head2;
        while(t1!=null){
            t2=t1.next;
            if(t1.random!=null) t2.random=t1.random.next;
            t1=t1.next.next;
        }
        // STEP - 4 split the LL
        t1=head;
        t2=head2;
        while(t1!=null){
            t1.next=t2.next;
            t1=t1.next;
            if(t1==null) break;
            t2.next=t1. next;
            t2=t2.next;
        }
        return head2;
        
    }
}