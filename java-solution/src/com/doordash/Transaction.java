package com.doordash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-05
 * Talk is Cheap,Show me the Code.
 **/
public class Transaction {
    HashMap<String, List<Integer>> map;
    Stack<Command> stack;
    int count = 0;

    public Transaction() {
        map = new HashMap<>();
        stack = new Stack<>();
    }

    public void setValue(String k, Integer v) {
        List<Integer> list = map.getOrDefault(k, new ArrayList<>());
        if (count == 0) {
            list.add(0, v);
        } else {
            stack.push(new Command(count, k, v));
            if (list.size() >= 1) {
                list.add(v);
            } else {
                list.add(Integer.MAX_VALUE);
                list.add(v);
            }
        }
        map.put(k, list);
    }

    public int getValue(String key) {
        List<Integer> list = map.get(key);
        if (list == null) {
            return -1;
        }

        int r = list.get(list.size() - 1);
        return r == Integer.MAX_VALUE ? -1 : r;
    }

    public void begin() {
        count++;
    }

    public boolean rollback() {
        if (count == 0) {
            return false;
        }

        while (!stack.isEmpty()) {
            if (stack.peek().transactionId == count) {//find the commands (maybe no one) of the lastest transaction and remove them from map
                Command command = stack.pop();
                List<Integer> list = map.get(command.key);
                list.remove(list.size() - 1);
            } else {
                break;
            }
        }
        count--;
        return true;
    }

    public boolean commit() {
        if (count == 0) {
            return false;
        }

        while (!stack.isEmpty()) {
            if (stack.peek().transactionId == count) {//find the commands (maybe no one) of the lastest transaction,update with the final value
                Command command = stack.pop();
                List<Integer> list = map.get(command.key);
                int finalValue = list.get(list.size() - 1);
                list.clear();
                list.add(0, finalValue);
            } else {
                break;
            }
        }
        count--;
        return true;
    }

    class Command {
        int transactionId;
        String key;
        int value;

        Command(int transactionId, String key, int value) {
            this.transactionId = transactionId;
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Transaction transaction = new Transaction();
        transaction.setValue("a", 10);

        transaction.begin();
        transaction.setValue("a", 11);
        transaction.setValue("a", 12);
        transaction.setValue("b", 20);
        System.out.println(transaction.getValue("a")); //12
        System.out.println(transaction.getValue("b")); // 20
        System.out.println(transaction.getValue("c"));//-1

        // a new transaction doing nothing
        transaction.begin();
        transaction.commit();

        transaction.rollback();  // can call commit to test cases to update map with final value
        //transaction.commit()

        System.out.println(transaction.getValue("a")); //10
        System.out.println(transaction.getValue("b")); //-1
        System.out.println(transaction.getValue("c")); // -1


    }

}
