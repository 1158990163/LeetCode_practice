package LeetCode;

///983. 最低票价
public class Solution33 {
    public int mincostTickets(int[] days, int[] costs) {
        int dp[] = new int[days.length];
        dp[0] = Math.min(costs[0],Math.min(costs[1],costs[2]));
        for(int i=1;i<days.length;i++){
            int c1,c2,c3;
            c1 = dp[i-1] + costs[0];

            int j;
            for(j = i-1;j>=0;j--)if(days[i]-days[j]>=7)break;
            c2 = j>=0?dp[j] + costs[1]:costs[1];
            for(j = i-1;j>=0;j--)if(days[i]-days[j]>=30)break;
            c3 = j>=0?dp[j] + costs[2]:costs[2];

            dp[i] = Math.min(c1,Math.min(c2,c3));
        }

        return dp[dp.length-1];
    }
}
