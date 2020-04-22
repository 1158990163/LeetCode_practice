package LeetCode;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，
//并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
//1.广度搜索


public class Solution03 {
    public int numIslands(char[][] grid) {

        int num = 0;
        int[] line = new int[]{1, -1, 0, 0};
        int[] list = new int[]{0, 0, 1, -1};
        if (grid.length == 0) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    num += 1;
                    Queue<int[]> island = new LinkedList<>();
                    island.offer(new int[]{i, j});
                    System.out.println("---------------------------------------");
                    while (!island.isEmpty()) {
                        int[] aim = island.poll();
                        for (int k = 0; k < 4; k++) {
                            int newX = aim[0] + line[k];
                            int newY = aim[1] + list[k];
                            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == '1') {
                                System.out.println(newX+"---"+newY);
                                grid[newX][newY] = '0';
                                island.offer(new int[]{newX, newY});
                            }
                        }
                    }
                }
            }
        }
        return num;


//        int num = 0;
//        int maxx = grid.length;
//        int maxy = grid[0].length;
//        if(grid.length==0){
//            return 0;
//        }
//        int[] line = new int[]{1, -1, 0, 0};
//        int[] list = new int[]{0, 0, 1, -1};
//        for (int i = 0; i < maxx; i++) {
//            for (int j = 0; j < maxy; j++) {
//                if (grid[i][j] == '1') {
//                    ++num;

//                    Queue<int[]> visit = new LinkedList<>();
//                    grid[i][j] = '0';
//                    visit.offer(new int[]{i, j});
//                    while (!visit.isEmpty()) {
//                        int[] temp = visit.poll();
//                        for (int k = 0; k < 4; k++) {
//                            int newX = temp[0] + line[k];
//                            int newY = temp[1] + list[k];
//                            if (newX >= 0 && newX < maxx && newY >= 0 && newY < maxy && grid[newX][newY]=='1'){
//                                visit.offer(new int[]{newX,newY});
//                                grid[newX][newY]='0';
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return num;
    }

    public static void main(String[] args) {
        char[][] test = new char[4][5];
        test[0] = new char[]{'1', '1', '1', '1', '0'};
        test[1] = new char[]{'1', '1', '0', '1', '0'};
        test[2] = new char[]{'1', '1', '0', '0', '0'};
        test[3] = new char[]{'0', '0', '0', '0', '0'};

        Solution03 s = new Solution03();
        int sum = s.numIslands(test);
        System.out.println(sum);


    }
}
