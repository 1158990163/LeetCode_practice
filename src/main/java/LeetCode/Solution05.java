package LeetCode;


//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
//        说明：你不能倾斜容器，且 n 的值至少为 2。
//1.双指针


public class Solution05 {
    public int maxArea(int[] height) {
        int head = 0;
        int tail = height.length - 1;
        int cup;
        if (height[head] <= height[tail]) {
            cup = height[head] * tail;
        } else {
            cup = height[tail] * tail;
        }
        for (int i = 0; i < height.length; i++) {
            if (height[head] <= height[tail]) {
                cup = Math.max(height[head] * (tail - head), cup);
                head += 1;
            } else if (height[head] > height[tail]) {
                cup = Math.max(height[tail] * (tail - head), cup);
                tail -= 1;
            }
            if (tail == head) {
                return cup;
            }
        }
        return cup;
    }

}


