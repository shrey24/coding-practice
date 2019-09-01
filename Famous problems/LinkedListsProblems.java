
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
 
class LinkedListsProblems {



    // input: current node to be deleted
    public static void deleteCurrentNode(ListNode node){
        // Note: doesnt work for last element..
        node.val = node.next.val; // copy value of next node
        node.next = node.next.next;
    }

    // Iterative
    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    // Recursive
    public static ListNode reverseListRec(ListNode head) {
        if(head == null){ // base case
            return head;
        }
        if(head.next == null){ // base case: single node
            return head;
        }
        ListNode curr = head; 
        ListNode next_of_curr = curr.next;
        head = next_of_curr;
        ListNode r_head = reverseList(head); // r_head is the head ptr of reversed link
        next_of_curr.next = curr; // reversing link
        curr.next = null;   //last node of reversed link points to null
         
        return r_head;
    }

    public static ListNode createList(int len){
        if(len <= 0){
            return null;
        }
        ListNode head = new ListNode(1);
        head.next = null;
        ListNode curr = head;

        for(int i=2; i<=len; i++){
            curr.next = new ListNode(i); 
            curr = curr.next;
        }
        return head;
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.print("/");
        System.out.println();
    }

    public static void main(String[] args) {
        /*
        ListNode l5 = createList(5);
        printList(l5);
        ListNode rev = reverseList(l5);
        
        printList(rev);
        printList(rev);
        */
        int arr[] = {0,0};
        int i = 0;
        arr[++i] = 1;
        System.out.println(arr[0]+" "+arr[1]);
    }
}