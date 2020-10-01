public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public static ListNode createArray(int[] a) {

        if (a.length == 0) {
            return null;
        }

        ListNode root = new ListNode(a[0]);
        ListNode cur = root;

        for (int j = 1; j < a.length; j++) {
            ListNode temp = new ListNode(a[j]);
            cur.next = temp;
            cur = cur.next;
        }

        return root;
    }
}