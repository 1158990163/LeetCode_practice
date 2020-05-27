package org.example;

import java.util.*;

public class test {
    public static void main(String[] args) {
        MyStack a = new MyStack();


    }
}

class MyStack {
    private Queue<Integer> queue;
    private int first;
    private int last;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.offer(x);
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }
    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.element();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}