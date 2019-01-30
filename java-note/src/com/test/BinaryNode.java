package com.test;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/7/18
 * Talk is Cheap,Show me the Code.
 **/
public class BinaryNode {
    int data;
    BinaryNode left;
    BinaryNode right;

    public BinaryNode(int data) {
        this(data, null, null);
    }

    public BinaryNode(int data, BinaryNode left, BinaryNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
