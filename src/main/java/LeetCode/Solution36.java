package LeetCode;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 394. 字符串解码
public class Solution36 {
    public String decodeString(String s) {
        String res = "";
        Queue<String> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            queue.offer(String.valueOf(aChar));
        }
        while (!queue.isEmpty()) {
            String temp = queue.poll();
            if (!"]".equals(temp)) {
                stack.push(temp);
            } else if ("]".equals(temp)) {
                String part = "";
                while (!"[".equals(stack.peek())) {
                    part = stack.pop() + part;
                }

                stack.pop();
                int m = 0;
                int time = 1;
                while (stack.size() > 0 && ("0".equals(stack.peek()) || "1".equals(stack.peek()) || "2".equals(stack.peek()) || "3".equals(stack.peek()) || "4".equals(stack.peek()) || "5".equals(stack.peek()) || "6".equals(stack.peek()) || "7".equals(stack.peek()) || "8".equals(stack.peek()) || "9".equals(stack.peek()))) {
                    int integer = Integer.valueOf(stack.peek());
                    m = m + integer * time;
                    time *= 10;
                    stack.pop();
                }

                String temp_res = "";
                for (int i = 0; i < m; i++) {
                    temp_res = temp_res + part;
                }
                stack.push(temp_res);
            }

        }
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "100[leetcode]";
        Solution36 solution36 = new Solution36();
        String s = solution36.decodeString(str);
        System.out.println(s);


    }
}
