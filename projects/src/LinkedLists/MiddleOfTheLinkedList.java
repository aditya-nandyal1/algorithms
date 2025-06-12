package LinkedLists;

public class MiddleOfTheLinkedList {

    /* Task: Given the head of a singly linked list, return the middle node of the linked list. If
    there are two middle nodes, return the second middle node. */

    /* Solution: Set two ListNode variables equal to head. While the faster moving node is not
    null and the node following it isn't null either, iterate the slower moving node once and the
    faster moving node twice. Return the slower moving node.
    */


    public ListNode middleNode(ListNode head) {

        ListNode left = head;
        ListNode right = head;

        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
        }
        return left;
    }

}
