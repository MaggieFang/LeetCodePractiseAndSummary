package com.ms;

import com.easy.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/14/19
 * Talk is Cheap,Show me the Code.
 **/
public class LinkedListCycleII142M {
    /**
     * KEYPOINTS:
     * <p>
     * https://blog.csdn.net/willduan1/article/details/50938210
     * 设置一个快指针fp和一个慢指针sp，所不同的是这回是要求出如果链表存在环，那么求出环入口的起始结点。
     * 接下来我们就是要从上面的算法中做出一定程度的改变就可以完成题目的要求了。我首先说一下具体的解法，推导过程后面再说。
     * 如果链表中存在环，那么fp和sp一定会相遇，当两个指针相遇的时候，我们设相遇点为c，此时fp和sp都指向了c，接下来令fp继续指向c结点，
     * sp指向链表头结点head，此时最大的不同是fp的步数变成为每次走一步，令fp和sp同时走，每次一步，那么它们再次相遇的时候即为环的入口结点
     * 快慢指针还可以用在：
     * 求有序链表中求出其中位数，这种问题也是设置快慢指针，当快指针到底链表尾部的时候，慢指针刚好指向链表中间的结点。
     * </p>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public ListNode detectCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
