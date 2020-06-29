package list;

/**
 * problem link: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/41/
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class DeleteNode {
    public void deleteNode(ListNode node) {
        if (node == null
            || node.next == null) {
            return ;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        DeleteNode deleteNode = new DeleteNode();

        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        deleteNode.deleteNode(node3);
    }
}
