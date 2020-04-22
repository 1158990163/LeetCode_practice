package LeetCode;


import java.util.Stack;
//写一个有push pop top getMin 方法的栈

public class Solution09 {
    public static void main(String[] args) {
        MinStack m = new MinStack();


    }

}

class MinStack {
    private Stack<Integer> main;
    private Stack<Integer> helper;

    public MinStack() {
        main = new Stack<>();
        helper = new Stack<>();

    }

    public void push(int x) {
        main.push(x);
        if (helper.isEmpty() || x <= helper.peek()) {
            helper.push(x);
        } else {
            helper.push(helper.peek());
        }
    }

    public void pop() {
        if (!main.isEmpty()) {
            main.pop();
            helper.pop();
        }
    }

    public int top(){
        if (!main.isEmpty()) {
            return main.peek();
        }
        throw new RuntimeException("非法操作");
    }

    public int getMin(){
        if (!helper.isEmpty()) {
            return helper.peek();
        }
        throw new RuntimeException("非法操作");
    }
}
