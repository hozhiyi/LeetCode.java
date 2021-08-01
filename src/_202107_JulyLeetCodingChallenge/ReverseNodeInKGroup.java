package _202107_JulyLeetCodingChallenge;

/*
LeetCode

Reverse Nodes in k-Group

Given a linked list, reverse the nodes of a linked list k at a time and return
its modified list.

k is a positive integer and is less than or equal to the length of the linked
list. If the number of nodes is not a multiple of k then left-out nodes, in the
end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be
changed.

Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]

Input: head = [1,2,3,4,5], k = 1
Output: [1,2,3,4,5]

Input: head = [1], k = 1
Output: [1]

Constraints:
- The number of nodes in the list is in the range sz.
- 1 <= sz <= 5000
- 0 <= Node.val <= 1000
- 1 <= k <= sz
 */
public class ReverseNodeInKGroup {

    public static void main(String[] args) {
        ListNode list1 = new ListNode();
        list1.value = 1;
        ListNode pointer = list1;
        for (int i = 2; i <= 4; i++) {
            ListNode listNode = new ListNode();
            listNode.value = i;
            pointer.next = listNode;
            pointer = pointer.next;
        }
        print(list1);
        System.out.println();
        print(new ReverseNodeInKGroup().reverseKGroup(list1, 3));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode previousHead = new ListNode();
        previousHead.next = head;
        ListNode pointer = previousHead;

        while (pointer != null) {
            pointer.next = reverseKNode(pointer.next, k);
            for (int i = 0; i < k && pointer != null; i++) {
                pointer = pointer.next;
            }
        }
//        return head;
        return previousHead.next;
    }

    /**
     * Reverse k number of Nodes
     *
     * @param head
     * @param k
     * @return Node
     */
    public ListNode reverseKNode(ListNode head, int k) {

        /*
        Eg: k = 3
        Node1,   Node2,   Node3,   Node4
          |                          |
        (initially end is here) (Now end is here)
         */
        ListNode end = head;
        while (end != null && k > 0) {
            end = end.next;
            k--;
        }

        /*
        if k > 0 while end is null and broke the while loop,
        it means that the list is shorter than k.
        Thus, head itself (first node) is returned.
         */
        if (k > 0) {
            return head;
        }

        /*
        If k is 0 and the list is long enough,
        Node1,   Node2,   Node3,   Node4
          |                          |
        (next)                  (end = last)
         */
        ListNode next = head;
        ListNode last = end;
        ListNode tempNext = null;
        /*
        Eg k = 3
        focusing on 'last', it basically points at Node4 first,
        then Node1, then Node2, then Node3
         */
        while (next != end) {
//            System.out.println("try:");
//            print(next);
//            System.out.println();

//            System.out.printf("%-15s%-25s%n", "next:", next.toString());
            tempNext = next.next;
//            System.out.printf("%-15s%-25s%n", "tempNext:", tempNext.toString());

//            System.out.printf("%-15s%-25s%n", "next.next:", next.next.toString());
            next.next = last;
//            System.out.printf("%-15s%-25s%n", "next.next:", next.next.toString());

//            System.out.printf("%-15s%-25s%n", "last:", last.toString());
            last = next;
//            System.out.printf("%-15s%-25s%n", "last:", last.toString());

//            System.out.printf("%-15s%-25s%n", "next:", next.toString());
            next = tempNext;
//            System.out.printf("%-15s%-25s%n", "next:", next.toString());
//            System.out.println();
        }
//        System.out.println("try:");
//        print(next);
//        System.out.println();
        return last;
    }

    /**
     * Print all Nodes in the list
     *
     * @param listNode
     */
    private static void print(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode);
            listNode = listNode.next;
        }
    }

    private static class ListNode {
        int value;
        ListNode next;

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + (next == null ? "" : next.value) +
                    '}';
        }
    }
}
