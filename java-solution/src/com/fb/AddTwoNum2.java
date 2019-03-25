package com.fb;

import com.easy.linkedlist.ListNode;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/1/18
 * Talk is Cheap,Show me the Code.
 **/
public class AddTwoNum2 {
    public static void main(String[] args){
        AddTwoNum2 test = new AddTwoNum2();
        int[] A1= new int[]{1,8};
        int[] A2 =new int[]{0};
        ListNode  h1 = new ListNode(A1[0]);
        ListNode h2 = new ListNode(A2[0]);
        ListNode tmp = h1;
        for (int i = 1; i < A1.length; i++) {
            tmp.next = new ListNode(A1[i]);
            tmp = tmp.next;
        }
        tmp.next = null;
        tmp = h2;
        for (int i = 1; i < A2.length; i++) {
            tmp.next = new ListNode(A2[i]);
            tmp = tmp.next;
        }
        tmp.next = null;

        System.out.println(test.addTwoNumbers(h1,h2));
        System.out.println(test.reverseLinkedList(h1));
        System.out.println(test.reverseLinkedList(h2));
    }
    /**
     * KEYPOINTS:
     * <p>
     *   we may think to traverse to get n1,n2 and compute n1+n2,but this is not good,
     *   because the n1,n2,sum may be large number.
     *   Key notes;
     *   traverse h1,h2 to get the actual number.
     *   reverse the h1,h2,
     *   traverse h1,h2 and add the same position of the the two link
     *   the result to create the new node of what we know.
     *   we also get a tmp to store the carrier.
     *
     *   question:
     *   when they are both null? return null?
     *   when they not same length, how align? e.g. {1,8},{0}
     *
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
    **/

    /**
     *
     **/
    public ListNode addTwoNumbers(ListNode h1,ListNode h2){
        if(h1 == null && h2 == null){
            return null;
        }

        int carrier = 0;
        ListNode n1 = h1;
        ListNode n2 = h2;
        ListNode h=null;
        ListNode node =null;
        while(n1 != null && n2 != null){
            int tmp = n1.val + n2.val + carrier ;
            carrier = tmp /10;
            if(h == null){
                h = new ListNode(tmp % 10);
                node = h;
            }else{
                node.next = new ListNode(tmp % 10);
                node = node.next;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        while(n1 != null){
            int tmp = n1.val +carrier;
            carrier = tmp /10;
            if(h == null){
                h = new ListNode(tmp %10);
                node = h;
            }else{
                node.next = new ListNode(tmp %10);
                node = node.next;

            }
            n1 =n1.next;
        }

        while(n2 != null){
            int tmp = n2.val +carrier;
            carrier = tmp /10;
            if(h == null){
                h = new ListNode(tmp %10);
                node = h;
            }else{
                node.next = new ListNode(tmp %10);
                node = node.next;

            }
            n2 =n2.next;
        }

        //donnot forget!when they are same length and has a carrier at highest digit. e.g 1->8,9->1,
        if(carrier != 0){
            if(h == null){
                h = new ListNode(carrier);
                node = h;
            }else{
                node.next = new ListNode(carrier);
                node = node.next;

            }
        }

        node.next = null;
        return h;


    }

    /**
     * we use 3 indice, pre,cur,next,
     let cur.next point to pre,
     before operating cur,save cur.next to tmp variable next for next time's cur.
     **/
    public ListNode reverseLinkedList(ListNode h1){
        if(h1 == null || h1.next == null){
            return h1;
        }

        ListNode pre = h1;
        ListNode cur= h1.next;
        ListNode next;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        h1.next = null;
        return pre;

    }

    // both null or either null of the two link ?
    // test case : 1) same length with forward carrier to expand digital 2-4-8  amd 5-6-4
    // 2) different length of the two link.
    public ListNode addTwoNumbersSimplerWay(ListNode h1,ListNode h2){
        if(h1 == null && h2 == null){
            return null;
        }
        if(h1 == null){
            return h2;
        }
        if(h2 == null){
            return h1;
        }

        ListNode n1 = h1;
        ListNode n2 = h2;
        int carrier = 0;
        ListNode head = null;
        ListNode pre = null;
        ListNode node = null;
        while(n1 != null && n2 != null){
            node = new ListNode((n1.val + n2.val +carrier) %10);
            carrier =  (n1.val + n2.val +carrier) /10;
            if(head == null){
                head = node;
            }
            if(pre != null){
                pre.next = node;
            }
            pre = node;
            n1 = n1.next;
            n2 = n2.next;
        }

        while(n1 != null){
            node = new ListNode((n1.val + carrier) %10);
            carrier = (n1.val + carrier)/10;
            pre.next = node;
            pre = node;
            n1 = n1.next;

        }

        while(n2 != null){
            node = new ListNode((n2.val + carrier) %10);
            carrier = (n2.val + carrier)/10;
            pre.next = node;
            pre = node;
            n2 = n2.next;
        }

        if(carrier != 0){
            node = new ListNode(carrier);
            pre.next = node;
        }
        node.next = null;

        return head;

    }

}
