package com.easy.linkedlist;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/19/18
 * Talk is Cheap,Show me the Code.
 **/
public class PalindromLinkedList234 {
    /**
     * KEYPOINTS:
     * <p>
     * we can get some idea form Q206
     * first,we count the total number of elements;
     * second, we divide the linklist logically into two parts. each have its own head.
     * third, reverse the latter head link list.
     * forth, compare the two linklist element each time.
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:O(n)
     * <p>
     * SPACE COMPLEXITY:O(1)
     * <p>
     **/
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        //count of the element
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }

        int latterIndex = count / 2;
        if (count % 2 != 0) {
            latterIndex++;
        }
        // reverse the latter list
        ListNode laterH = head;
        count = 0;
        while (count != latterIndex) {
            count++;
            laterH = laterH.next;
        }

        // reverse the latter linkedList
        ListNode reverseHead = revers(laterH);

        // compare the two parts
        while (head != null && reverseHead != null && head.val == reverseHead.val) {
            head = head.next;
            reverseHead = reverseHead.next;
        }
        if (reverseHead == null) {
            return true;
        }
        return false;

    }

    public ListNode revers(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = null;
        return pre;
    }
}
