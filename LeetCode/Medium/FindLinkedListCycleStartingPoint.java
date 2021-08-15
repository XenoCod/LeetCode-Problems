class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
        next = null;
      }
}


public class FindLinkedListCycleStartingPoint {
    static ListNode getCycleNode(ListNode head){
        ListNode temp= head, slow= head, fast= head;
        while(fast.next != null && fast!= null){
            slow=slow.next;
            fast= fast.next.next;
            if(slow== fast){
                while(temp!= slow){
                    slow= slow.next;
                    temp= temp.next;
                }
                return  temp;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        ListNode head= new ListNode(3);
        ListNode cycle= new ListNode(2);
        head.next=cycle;
        cycle.next= new ListNode(8);
        cycle.next.next= new ListNode(9);
        cycle.next.next.next=cycle;
        System.out.println(getCycleNode(head).val);
    }
}
