package LeetCode;

import java.util.*;

//  210. 课程表 II

public class Solution44 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        int[] ans = new int[numCourses];
        List[] edges = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i ++) {
            edges[i] = new ArrayList<Integer>();
        }
        for (int[] pre : prerequisites) {
            in[pre[0]] ++;
            edges[pre[1]].add(pre[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i ++) {
            if (in[i] == 0) queue.add(i);
        }
        int k = 0;
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            ans[k ++] = cur;
            for (Object course : edges[cur]) {
                int c = (int)course;
                in[c] --;
                if (in[c] == 0)
                    queue.add(c);
            }
        }
        return k == numCourses ? ans : new int[0];
    }
}
