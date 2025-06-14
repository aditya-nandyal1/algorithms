package LinkedLists;

public class ReverseLinkedListII {

    /* Task: Given the head of a singly linked list and two integers left and right where
    left <= right, reverse the nodes of the list from position left to position right, and return
    the reversed list. */

    /* Solution: Set a dummy node right before the node corresponding to left. Set a secondDummy
    node and a temp node at the node corresponding to left. Set a current and next node right after
    the node corresponding to left (if left = 1, assignment becomes more tricky). Until reaching
    a null value or the end of the range, reverse the  range of the linked list using
    the assigned variables. Then, set the secondDummy node's next attribute to current.
    Finally, if left != 1, set the dummy node's next attribute to temp (these final steps connect
    the reversed range to the rest of the linked list).
    */

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode toReturn = head;
        ListNode dummy;
        ListNode secondDummy;
        ListNode temp;
        ListNode current;
        ListNode next;
        int index = 1;

        while (index < left - 1) {
            head = head.next;
            index++;
        }
        if (head != null && head.next != null && left != 1) {
            dummy = head;
            secondDummy = head.next;
            temp = head.next;
            current = head.next.next;
            next = head.next.next;
        }
        else if (head != null && head.next != null && left == 1) {
            dummy = new ListNode(0);
            dummy.next = head;
            secondDummy = head;
            temp = head;
            current = head.next;
            next = head.next;
            index--;
        }
        else{
            return toReturn;
        }
        while (next != null && index < right-1) {
            next = current.next;
            current.next = temp;
            temp = current;
            current = next;
            index++;
        }

        secondDummy.next = current;
        if (left != 1) {
            dummy.next = temp;
        }
        else{
            return temp;
        }

        return toReturn;

    }

}
