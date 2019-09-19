import java.util.Arrays;
//  * Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
 
class MergeTwoLists{
    public int call_counter = 0;

    public ListNode mergeNLists(ListNode[] lists){
        while(lists.length > 1 ){
            int mid = lists.length/2;
            ListNode[] leftList = Arrays.copyOfRange(lists, 0, mid);
            ListNode[] rightList = Arrays.copyOfRange(lists, mid, lists.length);
    
            ListNode left = mergeNLists(leftList);
            ListNode right = mergeNLists(rightList);
            return merge2Lists(left, right);
        }
        return lists[0];
    }

    // Iterative
    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode ptr = head;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                ptr.next = l1;
                l1 = l1.next;
            }
            else{
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }

        if(l1 == null){
            ptr.next = l2;
        }
        else if (l2 == null){
            ptr.next = l1;
        }
        
        return head.next;
    }

    // recursive
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        this.call_counter++;
        //base case
        if(l1 == null && l2 == null){
            return null;
        }
        else if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
        
        // decision logic
        if(l1.val > l2.val){
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
        else{
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }

    ListNode makeList(int[] arr){
        if(arr.length == 0) return null;

        ListNode head = new ListNode(-1);
        ListNode ptr = head;
        for(int x : arr){
            ptr.next = new ListNode(x);
            ptr = ptr.next;
        }
        ptr.next = null;
        return head.next;
    }

    void printList(ListNode l){
        System.out.println();
        System.out.print("[ ");
        while(l != null){
            System.out.print(l.val+", ");
            l = l.next;
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        MergeTwoLists o = new MergeTwoLists();
        int [] a1 = {1 ,3, 7};
        int [] a2 = {2, 4, 6};
        int [] a3 = {5, 8, 9};
        ListNode l1 = o.makeList(a1);
        ListNode l2 = o.makeList(a2);
        o.printList(l1);
        o.printList(l2);
        // o.printList(o.mergeTwoLists(l1, l2));
        
        ListNode l3 = o.makeList(a3);

        ListNode[] lists = {l1, l2, l3} ;

        ListNode ans = o.mergeNLists(lists);
        o.printList(ans);

    }    
}
