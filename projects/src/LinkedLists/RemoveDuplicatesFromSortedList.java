package LinkedLists;

public class RemoveDuplicatesFromSortedList {

    /* Task: Given the head of a sorted linked list, delete all duplicates such that each element
    appears only once. Return the linked list sorted as well. */

    /* Solution: Set a temporary node equal to head (for the sole purpose of returning it). While
    the head node is not null and the node following it isn't null either, while the value of the
    head node is equal to the value of the following node, make the head's next node the node
    following the next node (essentially deleting the next node).
    */


    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (head != null && head.next != null) {
            while (head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
            }
            head = head.next;
        }

        return temp;

    }

}
