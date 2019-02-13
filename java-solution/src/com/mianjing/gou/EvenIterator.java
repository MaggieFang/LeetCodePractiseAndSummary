package com.mianjing.gou;

import java.net.Inet4Address;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-12
 * Talk is cheap,show me the Code.
 **/
public class EvenIterator {
    //第一题实现一个even number iterator. 返回所有的even number. 从0开始，到int_max 结束。一开始听到这题，我一直在纠结input是什么，结果他说没有input
    int cur = -2;
    private static final int MAX = Integer.MAX_VALUE;

    public boolean hasNext() {
        return cur != MAX;
    }

    public int next() {
        cur += 2;
        return cur;
    }

    public static void main(String[] args){
        EvenIterator test = new EvenIterator();
        while (test.hasNext()){
            System.out.print(test.next()+"\t");
        }
    }
}
