package LeetCode;

import java.util.Stack;

public class Solution13 {
    public int evalRPN(String[] tokens) {
        Stack<String> sta = new Stack<>();
        int result;
        if (tokens.length == 0) {
            return 0;
        }
        for (String token : tokens) {
            if("/".equals(token)){
                int sum1 = Integer.parseInt(sta.pop());
                int sum2 = Integer.parseInt(sta.pop());
                sta.push(String.valueOf(sum2/sum1));
                continue;
            }
            if("*".equals(token)){
                int sum1 = Integer.parseInt(sta.pop());
                int sum2 = Integer.parseInt(sta.pop());
                sta.push(String.valueOf(sum2*sum1));
                continue;
            }
            if("-".equals(token)){
                int sum1 = Integer.parseInt(sta.pop());
                int sum2 = Integer.parseInt(sta.pop());
                sta.push(String.valueOf(sum2-sum1));
                continue;
            }
            if("+".equals(token)){
                int sum1 = Integer.parseInt(sta.pop());
                int sum2 = Integer.parseInt(sta.pop());
                sta.push(String.valueOf(sum2+sum1));
                continue;
            }
            sta.push(token);
        }
        return Integer.parseInt(sta.pop());
    }

    public static void main(String[] args) {
        String[] a = new String[]{"4","13","5","/","+"};
        Solution13 s  = new Solution13();
        int i = s.evalRPN(a);
        System.out.println(i);
    }
}
