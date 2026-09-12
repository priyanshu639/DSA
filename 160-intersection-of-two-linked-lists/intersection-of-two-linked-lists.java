
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temA=headA;
        int lenA=0;
        while(temA!=null){
            temA=temA.next;
            lenA++;
        }
        ListNode temB=headB;
        int lenB=0;
        while(temB!=null){
            temB=temB.next;
            lenB++;
        }
        temA=headA;
        temB=headB;
        
        if(lenA>lenB){
            for(int i=0;i<lenA-lenB;i++){
                temA=temA.next;
            }
        }
        else{//lenB>lenA
            for(int i=0;i<lenB-lenA;i++){
                temB=temB.next;
            }
        }

        while(temA!=temB){
            temA=temA.next;
            temB=temB.next;
        }
        return temA;//temB bhi return kr skte ho
    }
}