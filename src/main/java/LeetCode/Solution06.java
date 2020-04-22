package LeetCode;

import java.util.*;

//你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
//
//        锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
//
//        列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
//
//        字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。

//1.广度搜索

public class Solution06 {
    public int openLock(String[] deadends, String target) {
        String head = "0000";
        Set<String> used = new HashSet<>();
        Queue<String> list = new LinkedList<>();
        Map<String, Integer> step = new HashMap<>();
        Collections.addAll(used, deadends);
        int min_step = 0;
        if (used.contains(head)) {
            return -1;
        }
        list.offer(head);
        step.put(head, 0);
        while (!list.isEmpty()) {
            String temp = list.poll();
            int temp_step = step.get(temp);
            if (temp.equals(target)){
                return temp_step;
            }
            for (int i = 0; i < 4; i++) {
                int up = (temp.charAt(i) - 48 - 1 + 10) % 10;
                String up1 = temp.substring(0, i) + ((char) (up + 48)) + temp.substring(i + 1, 4);
                if(!used.contains(up1)){
                    used.add(up1);
                    step.put(up1,temp_step+1);
                    list.offer(up1);
                }
                int down = (temp.charAt(i) - 48 + 1 + 10) % 10;
                String down1 = temp.substring(0, i) + ((char) (down + 48)) + temp.substring(i + 1, 4);
                if(!used.contains(down1)){
                    used.add(down1);
                    step.put(down1,temp_step+1);
                    list.offer(down1);
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String[] deadends = {""};
        String target = "1111";
        Solution06 s= new Solution06();
        int a= s.openLock(deadends,target);
        System.out.println(a);

    }
}
