package LeetCode;

import java.util.Iterator;
import java.util.Stack;

//根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
//
//        例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
public class Solution11 {
    public int[] dailyTemperatures(int[] T) {

        int length = T.length;
        int[] res =new int[length];
        Stack<Integer> size = new Stack<>();
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if(i>1&&T[i]==T[i-1]){
                    if(res[i-1]>0){
                        res[i] = res[i-1]-1;
                    }
                    break;
                }
                size.push(T[j]);
                if(T[i]<T[j]){
                    res[i]=size.size();
                    break;
                }
            }
            size.clear();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temp = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        Solution11 s= new Solution11();
        int[] ints = s.dailyTemperatures(temp);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
        Stack<Integer> a = new Stack<>();
        a.pop();
    }
}
