package list;

/**
 * problem link: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/42/
 */
public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        int size = size(head);

        ListNode p = dummy;
        int i = 0;
        while (i++ < size - n) {
            p = p.next;
        }
        p.next = p.next.next;

        return dummy.next;
    }

    public static ListNode removeNthFromEndV2(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p = dummy, q = dummy;
        int i = 0;
        while (i++ < n+1) {
            p = p.next;
        }
        while (p != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;

        return dummy.next;
    }

    private static int size(ListNode node) {
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }

        return size;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1 = removeNthFromEndV2(node1, 1);
        node1 = removeNthFromEndV2(node1, 2);
        node1 = removeNthFromEndV2(node1, 3);
        node1 = removeNthFromEndV2(node1, 3);
    }
}
