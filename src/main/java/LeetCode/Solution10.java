package LeetCode;

import java.util.Stack;

//给定的字符串，判断(){}[]三种括号排列是否正常

public class Solution10 {
    public boolean isValid(String s) {
        Stack<Character> test = new Stack<>();
        char[] chars = s.toCharArray();
        if (chars.length<1){return true;}
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]!='}'&&chars[i]!=')'&&chars[i]!=']'){
                test.push(chars[i]);
            }
            if (chars[i]=='}'){
                if(test.isEmpty()||test.peek()!='{'){
                    return false;
                }else {
                    test.remove(test.size()-1);
                }
            }
            if (chars[i]==')'){
                if(test.isEmpty()||test.peek()!='('){
                    return false;
                }else {
                    test.remove(test.size()-1);
                }
            }
            if (chars[i]==']'){
                if(test.isEmpty()||test.peek()!='['){
                    return false;
                }else {
                    test.remove(test.size()-1);
                }
            }
        }
        if (test.isEmpty()){
            return true;
        }
        return false;
    }
}
