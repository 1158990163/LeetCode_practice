package LeetCode;

//硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。


public class Solution19 {

    //无脑遍历
    //    public int waysToChange(int n) {
//        int sum = 0;
//        for (int i = 0; i <= (n / 25); i++) {
//            int n_10 = n - 25 * i;
//            for (int j = 0; j <= (n_10 / 10); j++) {
//                int n_5 = n_10 - 10 * j;
//                sum = (n_5 / 5) + 1 + sum;
//            }
//        }
//        return sum;
//    }

    //    //动态规划
//    public int waysToChange(int n) {
//        int[] coims = new int[]{1, 5, 10, 25};
//        int mod = 1000000007;
//        int[][] dp = new int[4][n + 1];
//        for (int i = 0; i <= n; i++) {
//            dp[0][i] = 1;
//        }
//        for (int i = 1; i < 4; i++) {
//            dp[i][0]=1;
//        }
//        for (int i = 1; i < 4; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (j<coims[i]){
//                    dp[i][j] = dp[i-1][j];
//                }else {
//                    dp[i][j] = (dp[i-1][j]+dp[i][j-coims[i]])%mod;
//                }
//            }
//        }
//        return dp[3][n];
//    }
//  //非01背包，可优化 少一维
    public int waysToChange(int n) {

        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = 1;
        }
        int[] coins = new int[]{5, 10, 25};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= n; j++) {
                if (j>=coins[i]) dp[j] = (dp[j-coins[i]]+dp[j])%1000000007;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 900750;
        Solution19 a = new Solution19();
        int i = a.waysToChange(n);
        System.out.println(i);
    }
}
