package com.mianjing.gou;

import com.easy.linkedlist.ListNode;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/14/19
 * Talk is Cheap,Show me the Code.
 **/
public class SkipMDeleteN {
    public ListNode deleteN(ListNode head, int M, int N){
        ListNode cur = head;
        while(cur != null){
            for(int cnt = 1;cnt < M && cur != null ; cnt++){
                cur = cur.next;
            }

            if(cur  ==  null){
                return head;
            }

            ListNode t = cur.next;
            for(int cnt = 1; cnt <= N && t != null; cnt++){
                t = t.next;
            }

            cur.next = t;
            cur = t;
        }
        return head;

    }

}
