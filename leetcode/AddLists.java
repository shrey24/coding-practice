/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 *  Add the two numbers and return it as a linked list.
    You may assume the two numbers do not contain any leading zero,
    except the number 0 itself.
    Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */

class AddLists{
    
    // input LISTS are in form MSB ->...->LSB
    /**************************************************************
     * Example: 
     * (2 -> 4 -> 3) == 243
     * (5 -> 6 -> 4) == 564     * 
     */
    // recursive 
    public ListNode addTwoLists(ListNode l1, ListNode l2) {
        int len1 = this.len(l1);
        int len2 = this.len(l2);
        int diff = Math.abs(len1 - len2);
        ListNode longerList = (len1 > len2)?l1:l2;
        ListNode shortList = (len1 <= len2)?l1:l2;
        // ListNode slptr = shortList;

        for(int i=0; i<diff; i++){  // append leading zeros
            ListNode shortHead = new ListNode(0);
            shortHead.next = shortList;
            shortList = shortHead;
        }
        // now len(l1) == len(l2)
        ListNode head = addTwoListsRec(longerList, shortList);
        int carry = head.val/10;
        if(carry != 0){
            ListNode res = new ListNode(carry);
            res.next = head;
            head.val %= 10;
            return res;
        }
        else{
            return head;   
        }        
    }
    
    // l1 and l2 must be of same length
    public ListNode addTwoListsRec(ListNode l1, ListNode l2) {
        if(l1.next == null){
            return new ListNode(l1.val + l2.val);
        }
        
        ListNode head = new ListNode(0);
        head.next = addTwoListsRec(l1.next, l2.next);
        
        int carry = head.next.val/10;
        head.next.val %= 10;
        
        head.val = carry + l1.val + l2.val;
        
        return head;
    }
    
    public int len(ListNode l){
        int i = 0;
        while(l != null){
            i++;
            l = l.next;
        }
        
        return i;        
    }


    /* ************************************************************************
    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.
     */    
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        int c = 0;
        ListNode ptr = head;
        
        while(l1 != null || l2 != null){
            if(l1 == null){
                ptr.next = new ListNode((l2.val + c)%10);
                ptr = ptr.next;
                c = (l2.val + c)/10;
                l2 = l2.next;
            }
            else if(l2 == null){
                ptr.next = new ListNode((l1.val + c)%10);
                ptr = ptr.next;
                c = (l1.val + c)/10;  
                l1 = l1.next;
            }
            else{
                ptr.next = new ListNode((l1.val+l2.val+c)%10);
                ptr = ptr.next;
                c = (l1.val+l2.val+c)/10;                
                l1 = l1.next;
                l2 = l2.next;
            }   
        }  
        ptr.next = (c == 1)?(new ListNode(1)):null;
        return head.next;        
    }



}