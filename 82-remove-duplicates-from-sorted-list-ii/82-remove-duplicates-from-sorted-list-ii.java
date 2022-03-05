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
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode ptr = head, prevPtr = null;
        boolean dupPresent = false;
        
        for (; ptr != null && ptr.next != null; ptr=ptr.next) {
            dupPresent = false;
            while (ptr != null && ptr.next != null && ptr.val == ptr.next.val) {
                ptr.next = ptr.next.next;
                dupPresent = true;
            }
            
            if (dupPresent) {
                if (prevPtr == null) {
                    head = ptr.next;    
                } else {
                    prevPtr.next = ptr.next;
                }
            } else {
                prevPtr = ptr;
            }
        }
        
        return head;
    }
}