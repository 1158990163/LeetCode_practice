package LeetCode;

import java.util.*;

//841. 钥匙和房间

public class Solution39 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int room_len = rooms.size();
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        set.add(0);
        while (!queue.isEmpty()) {
            List<Integer> room = rooms.get(queue.poll());
            for (int r : room) {
                if (!set.contains(r)) {
                    set.add(r);
                    queue.add(r);
                }
            }
        }
        return set.size() >= rooms.size();
    }
}
