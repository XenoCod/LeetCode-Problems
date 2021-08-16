

public class RotateALinkedList {
    static ListNode rotateList(ListNode head, int k){
        if(head==null) return  null;
        int count= 1;
        ListNode temp= head;//to count till the last nodes
        while(temp.next!=null) {
            temp= temp.next;// we go to the last node
            count++;
        }
        temp.next= head;//we make the lastnode point to head ..making it as a circular linked list
        k=k%count;//just making sure that k remains smallert thn the count
        k= count - k;// we count till the kth node
        while(k-->0) temp= temp.next;
        head= temp.next;//we make the (k+1)th as the head
        temp.next= null;//we make the kth node to null
        return head;





    }
    public static void main(String[] args) {
        ListNode head= new ListNode(1);
        head.next= new ListNode(2);
        head.next.next= new ListNode(3);
        head.next.next.next= new ListNode(4);
        head.next.next.next.next= new ListNode(5);
        ListNode res=rotateList(head, 2);
        while(res!=null){
            System.out.print(res.val+" ");
            res= res.next;
        }

    }
}
