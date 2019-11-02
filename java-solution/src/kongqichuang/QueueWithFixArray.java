package kongqichuang;

import java.util.ArrayList;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-11-01
 **/
public class QueueWithFixArray {
    int max;
    ListNode head;
    ListNode tail;
    int front; // point to the one to dequeue
    int rear; // point to the last one enqueue.
    int count;

    public QueueWithFixArray(int capacity) {
        this.max = capacity;
        this.head = new ListNode(max);
        this.tail = this.head;
    }

    public void enQueue(int e){
       tail.data[rear++] = e;
       if(rear == max){
           rear = 0;
           tail.next = new ListNode(max);
           tail = tail.next;
       }
       count++;
    }

    public Integer dequeue(){
        if(isEmpty()){
            return  null;
        }

        int e = head.data[front++];
        if(front == max){
            front = 0;
            head = head.next;
        }
        return e;
    }

    public boolean isEmpty(){
        return  count == 0;
    }

    class ListNode{
       // private int MAX;
        int[]  data;
        ListNode next;

        public ListNode(int max) {
            this.data = new int[max];
        }
//        public ListNode add(int e){
//            if(this.data.size() >= MAX){
//                this.next = new ListNode();
//                return this.next.add(e);
//            }else {
//                data.add(e);
//                return this;
//            }
//        }
//
//        public ListNode remove(){
//            if(data.size() > 0){
//
//            }
//        }

    }

}
