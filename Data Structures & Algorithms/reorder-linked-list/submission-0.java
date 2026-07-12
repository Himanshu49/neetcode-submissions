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
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        int count = 0;
        ListNode curr = head;
        while(curr!=null){
            stack.push(curr);
            count++;
            curr = curr.next;
        }

        int half = count/2;
        ListNode next = null, top = null;
        curr = head;
        while(half>0){
            next = curr.next;
            top = stack.pop();
            curr.next = top;
            top.next = next;
            curr = next;
            half--;
        }

        curr.next = null;
    }
}
