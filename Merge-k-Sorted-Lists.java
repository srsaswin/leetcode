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
    public ListNode mergeKLists(ListNode[] lists) { 
        Queue<ListNode> pq = new PriorityQueue<>((a,b)->a.val - b.val);
        for(ListNode n:lists) if(n != null) pq.offer(n); 
        ListNode root = pq.poll();
        if(root!= null && root.next != null) pq.offer(root.next);
        ListNode temp = root;
        while(!pq.isEmpty()){
            temp.next = pq.poll();
            temp = temp.next;
            if(temp.next != null) pq.offer(temp.next);
        }
        return root;

    }
}